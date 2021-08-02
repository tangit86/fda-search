package com.than.fdasearch.web;

import com.than.fdasearch.api.SearchApi;
import com.than.fdasearch.api.model.ApplicationSearchResult;
import com.than.fdasearch.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController implements com.than.fdasearch.api.SearchApi {

    @Autowired
    SearchService searchService;

    @Override
    public ResponseEntity<ApplicationSearchResult> searchApplications(String manufacturer, String substance, Integer page, Integer limit) {
        try {
            ApplicationSearchResult result = searchService.search(manufacturer,substance,page,limit);
            return new ResponseEntity<ApplicationSearchResult>(result,HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ApplicationSearchResult>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
