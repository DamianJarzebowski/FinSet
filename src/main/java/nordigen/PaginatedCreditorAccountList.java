/*
 * Nordigen Account Information Services API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0 (v2)
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package nordigen;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PaginatedCreditorAccountList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2023-02-25T17:56:18.166387600+01:00[Europe/Warsaw]")
public class PaginatedCreditorAccountList {

  
  @JsonProperty("count")
  private Integer count = null;
  
  
  @JsonProperty("next")
  private String next = null;
  
  
  @JsonProperty("previous")
  private String previous = null;
  
  
  @JsonProperty("results")
  private List<CreditorAccount> results = null;
  
  public PaginatedCreditorAccountList count(Integer count) {
    this.count = count;
    return this;
  }

  
  /**
  * Get count
  * @return count
  **/
  @ApiModelProperty(example = "123", value = "")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }
  
  public PaginatedCreditorAccountList next(String next) {
    this.next = next;
    return this;
  }

  
  /**
  * Get next
  * @return next
  **/
  @ApiModelProperty(example = "http://api.example.org/accounts/?offset=400&limit=100", value = "")
  public String getNext() {
    return next;
  }
  public void setNext(String next) {
    this.next = next;
  }
  
  public PaginatedCreditorAccountList previous(String previous) {
    this.previous = previous;
    return this;
  }

  
  /**
  * Get previous
  * @return previous
  **/
  @ApiModelProperty(example = "http://api.example.org/accounts/?offset=200&limit=100", value = "")
  public String getPrevious() {
    return previous;
  }
  public void setPrevious(String previous) {
    this.previous = previous;
  }
  
  public PaginatedCreditorAccountList results(List<CreditorAccount> results) {
    this.results = results;
    return this;
  }

  public PaginatedCreditorAccountList addResultsItem(CreditorAccount resultsItem) {
    
    if (this.results == null) {
      this.results = new ArrayList<CreditorAccount>();
    }
    
    this.results.add(resultsItem);
    return this;
  }
  
  /**
  * Get results
  * @return results
  **/
  @ApiModelProperty(value = "")
  public List<CreditorAccount> getResults() {
    return results;
  }
  public void setResults(List<CreditorAccount> results) {
    this.results = results;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginatedCreditorAccountList paginatedCreditorAccountList = (PaginatedCreditorAccountList) o;
    return Objects.equals(this.count, paginatedCreditorAccountList.count) &&
        Objects.equals(this.next, paginatedCreditorAccountList.next) &&
        Objects.equals(this.previous, paginatedCreditorAccountList.previous) &&
        Objects.equals(this.results, paginatedCreditorAccountList.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, next, previous, results);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginatedCreditorAccountList {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    previous: ").append(toIndentedString(previous)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  
}


