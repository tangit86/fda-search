package com.than.fdasearch.web;

import com.than.fdasearch.api.model.ApplicationEntry;
import com.than.fdasearch.services.LocalApplicationEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ApplicationsController implements com.than.fdasearch.api.ApplicationsApi {

    @Autowired
    LocalApplicationEntryService localApplicationEntryService;

    @Override
    public ResponseEntity<List<ApplicationEntry>> viewSavedApplications() {
        List<ApplicationEntry> result = null;
        HttpStatus status = HttpStatus.OK;
        try{
            result = localApplicationEntryService.getAll();
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<List<ApplicationEntry>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<ApplicationEntry>>(result,status);
    }

    @Override
    public ResponseEntity<Void> saveApplication(ApplicationEntry body) {
        try {
            localApplicationEntryService.save(body);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
