package com.than.fdasearch.services.mappers;

import com.than.fdasearch.persistence.LocalApplicationEntry;
import com.than.fdasearch.persistence.LocalApplicationEntryId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class ApplicationEntryMapper {

    public LocalApplicationEntry mapToLocal(com.than.fdasearch.api.model.ApplicationEntry applicationEntry){
        LocalApplicationEntry result = new LocalApplicationEntry();
        LocalApplicationEntryId id = new LocalApplicationEntryId(applicationEntry.getId(),applicationEntry.getManufacturerName(),applicationEntry.getSubstanceName());
        result.setLocalApplicationEntryId(id);
        result.setProductNumbers(new HashSet<>(applicationEntry.getProductNumbers()));
        return result;
    }

    public com.than.fdasearch.api.model.ApplicationEntry mapToEntry(LocalApplicationEntry localApplicationEntry){
        com.than.fdasearch.api.model.ApplicationEntry result = new com.than.fdasearch.api.model.ApplicationEntry();
        result.setId(localApplicationEntry.getLocalApplicationEntryId().getId());
        result.setManufacturerName(localApplicationEntry.getLocalApplicationEntryId().getManufacturerName());
        result.setSubstanceName(localApplicationEntry.getLocalApplicationEntryId().getSubstanceName());
        result.setProductNumbers(new ArrayList<>(localApplicationEntry.getProductNumbers()));
        return result;
    }
}
