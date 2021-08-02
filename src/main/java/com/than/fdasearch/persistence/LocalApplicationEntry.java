package com.than.fdasearch.persistence;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LocalApplicationEntry {

    public LocalApplicationEntryId getLocalApplicationEntryId() {
        return localApplicationEntryId;
    }

    public void setLocalApplicationEntryId(LocalApplicationEntryId localApplicationEntryId) {
        this.localApplicationEntryId = localApplicationEntryId;
    }

    @EmbeddedId
    LocalApplicationEntryId localApplicationEntryId;

    @ElementCollection
    private Set<Integer> productNumbers;

    public Set<Integer> getProductNumbers() {
        return productNumbers;
    }

    public void setProductNumbers(Set<Integer> productNumbers) {
        this.productNumbers = productNumbers;
    }
}
