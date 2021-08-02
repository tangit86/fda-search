package com.than.fdasearch.services;

import com.than.fdasearch.api.model.ApplicationSearchResult;
import com.than.fdasearch.fdaclient.model.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

@Service
public class SearchService {

    Logger logger = LoggerFactory.getLogger(LocalApplicationEntryService.class);

    @Autowired
    String fdaApiHost;

    @Autowired
    RestTemplate restTemplate;

    public ApplicationSearchResult search(String manufacturerName, String substanceName, Integer page, Integer limit) throws Exception {
        int sanitizedPage = page ==null || page < 1 ? 1 : page;
        int sanitizedLimit = limit==null || limit < 1 ?  1 : (limit > 99 ? 99 : limit);
        int skip = (sanitizedPage-1)*sanitizedLimit;
        Root root = null;
        try {
            ResponseEntity<Root> result = restTemplate.getForEntity(getUrl(manufacturerName, substanceName, skip, sanitizedLimit), Root.class);
            if (result.getStatusCode().is2xxSuccessful()) {
                root = result.getBody();
            }
        }catch (HttpClientErrorException.NotFound e){
            logger.error("Error while fetching search results",e);
        }
        return getPaginated(root,sanitizedPage,sanitizedLimit);
    }

    private com.than.fdasearch.api.model.ApplicationSearchResult getPaginated(Root body,int page, int limit) {
        com.than.fdasearch.api.model.ApplicationSearchResult result = new ApplicationSearchResult();
        int total = body==null ? 0 : body.meta.results.total;
        int totalPages = total/limit + (total%limit>0 ? 1 : 0);
        result.setTotalElements(total);
        result.setPageElements(limit);
        result.setTotalPages(totalPages);
        result.setPage(page);
        result.setPayload(body==null ? new ArrayList<>() : body.results);
        return result;
    }

    private String getUrl(String manufacturerName, String substanceName, int skip, int limit) throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append(this.fdaApiHost);
        sb.append("drug/drugsfda.json?search=");

        if (isNullOrEmpty(manufacturerName)) {
            throw new Exception("Mandatory search term is missing");
        } else {
            sb.append(addTerm("openfda.manufacturer_name", manufacturerName));
        }

        if (!isNullOrEmpty(substanceName)) {
            sb.append("+AND+");
            sb.append(addTerm("openfda.substance_name", substanceName));
        }


        sb.append(String.format("&skip=%d",skip));
        sb.append(String.format("&limit=%d",limit));

        logger.debug("Requesting: " + sb.toString());
        return sb.toString();
    }

    private String addTerm(String term, String value) {
        return String.format("%s:\"%s\"", term, value);
    }

    private boolean isNullOrEmpty(String s){
        return s==null || s.isEmpty() || s.isBlank();
    }
}
