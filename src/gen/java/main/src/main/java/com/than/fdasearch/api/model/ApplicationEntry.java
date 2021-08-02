package com.than.fdasearch.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApplicationEntry
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-02T10:15:18.406887400+03:00[Europe/Bucharest]")
public class ApplicationEntry   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("manufacturerName")
  private String manufacturerName;

  @JsonProperty("substanceName")
  private String substanceName;

  @JsonProperty("productNumbers")
  @Valid
  private List<Integer> productNumbers = null;

  public ApplicationEntry id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ApplicationEntry manufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
    return this;
  }

  /**
   * Get manufacturerName
   * @return manufacturerName
  */
  @ApiModelProperty(value = "")


  public String getManufacturerName() {
    return manufacturerName;
  }

  public void setManufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }

  public ApplicationEntry substanceName(String substanceName) {
    this.substanceName = substanceName;
    return this;
  }

  /**
   * Get substanceName
   * @return substanceName
  */
  @ApiModelProperty(value = "")


  public String getSubstanceName() {
    return substanceName;
  }

  public void setSubstanceName(String substanceName) {
    this.substanceName = substanceName;
  }

  public ApplicationEntry productNumbers(List<Integer> productNumbers) {
    this.productNumbers = productNumbers;
    return this;
  }

  public ApplicationEntry addProductNumbersItem(Integer productNumbersItem) {
    if (this.productNumbers == null) {
      this.productNumbers = new ArrayList<>();
    }
    this.productNumbers.add(productNumbersItem);
    return this;
  }

  /**
   * Get productNumbers
   * @return productNumbers
  */
  @ApiModelProperty(value = "")


  public List<Integer> getProductNumbers() {
    return productNumbers;
  }

  public void setProductNumbers(List<Integer> productNumbers) {
    this.productNumbers = productNumbers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationEntry applicationEntry = (ApplicationEntry) o;
    return Objects.equals(this.id, applicationEntry.id) &&
        Objects.equals(this.manufacturerName, applicationEntry.manufacturerName) &&
        Objects.equals(this.substanceName, applicationEntry.substanceName) &&
        Objects.equals(this.productNumbers, applicationEntry.productNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, manufacturerName, substanceName, productNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationEntry {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    manufacturerName: ").append(toIndentedString(manufacturerName)).append("\n");
    sb.append("    substanceName: ").append(toIndentedString(substanceName)).append("\n");
    sb.append("    productNumbers: ").append(toIndentedString(productNumbers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

