package com.than.fdasearch.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApplicationSearchResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-08-02T10:15:18.406887400+03:00[Europe/Bucharest]")
public class ApplicationSearchResult   {
  @JsonProperty("page")
  private Integer page;

  @JsonProperty("totalPages")
  private Integer totalPages;

  @JsonProperty("pageElements")
  private Integer pageElements;

  @JsonProperty("totalElements")
  private Integer totalElements;

  @JsonProperty("payload")
  private Object payload;

  public ApplicationSearchResult page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  */
  @ApiModelProperty(value = "")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public ApplicationSearchResult totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Get totalPages
   * @return totalPages
  */
  @ApiModelProperty(value = "")


  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public ApplicationSearchResult pageElements(Integer pageElements) {
    this.pageElements = pageElements;
    return this;
  }

  /**
   * Get pageElements
   * @return pageElements
  */
  @ApiModelProperty(value = "")


  public Integer getPageElements() {
    return pageElements;
  }

  public void setPageElements(Integer pageElements) {
    this.pageElements = pageElements;
  }

  public ApplicationSearchResult totalElements(Integer totalElements) {
    this.totalElements = totalElements;
    return this;
  }

  /**
   * Get totalElements
   * @return totalElements
  */
  @ApiModelProperty(value = "")


  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public ApplicationSearchResult payload(Object payload) {
    this.payload = payload;
    return this;
  }

  /**
   * Get payload
   * @return payload
  */
  @ApiModelProperty(value = "")


  public Object getPayload() {
    return payload;
  }

  public void setPayload(Object payload) {
    this.payload = payload;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationSearchResult applicationSearchResult = (ApplicationSearchResult) o;
    return Objects.equals(this.page, applicationSearchResult.page) &&
        Objects.equals(this.totalPages, applicationSearchResult.totalPages) &&
        Objects.equals(this.pageElements, applicationSearchResult.pageElements) &&
        Objects.equals(this.totalElements, applicationSearchResult.totalElements) &&
        Objects.equals(this.payload, applicationSearchResult.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, totalPages, pageElements, totalElements, payload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationSearchResult {\n");
    
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    pageElements: ").append(toIndentedString(pageElements)).append("\n");
    sb.append("    totalElements: ").append(toIndentedString(totalElements)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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

