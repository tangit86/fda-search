package com.than.fdasearch.services;

import com.than.fdasearch.persistence.LocalApplicationEntryRepository;
import com.than.fdasearch.services.mappers.ApplicationEntryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalApplicationEntryService {

    Logger logger = LoggerFactory.getLogger(LocalApplicationEntryService.class);

    @Autowired
    ApplicationEntryMapper applicationEntryMapper;

    @Autowired
    LocalApplicationEntryRepository localApplicationEntryRepository;

    public void save(com.than.fdasearch.api.model.ApplicationEntry applicationEntry) {
        try{
            localApplicationEntryRepository.save(applicationEntryMapper.mapToLocal(applicationEntry));
        }catch (Exception e){
            logger.error("Could not save application",e);
            throw e;
        }
    }

    public List<com.than.fdasearch.api.model.ApplicationEntry> getAll() {
        List<com.than.fdasearch.api.model.ApplicationEntry> result = new ArrayList<>();
        try{
            localApplicationEntryRepository.findAll().iterator().forEachRemaining(it->result.add(applicationEntryMapper.mapToEntry(it)));
        }catch (Exception e){
            logger.error("Could not load local applications",e);
            throw e;
        }
        return result;
    }


}
