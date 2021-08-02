package com.than.fdasearch.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LocalApplicationEntryId implements Serializable {

    private String id;
    private String manufacturerName;
    private String substanceName;

    public LocalApplicationEntryId(){

    }

    public LocalApplicationEntryId(String id, String manufacturerName, String substanceName) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.substanceName = substanceName;
    }

    public String getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSubstanceName() {
        return substanceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocalApplicationEntryId)) return false;
        LocalApplicationEntryId that = (LocalApplicationEntryId) o;
        return this.getId().equals(that.getId()) && this.getManufacturerName().equals(that.getManufacturerName()) && this.getSubstanceName().equals(that.getSubstanceName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(),this.getManufacturerName(),this.getSubstanceName());
    }
}
