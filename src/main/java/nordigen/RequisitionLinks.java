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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * RequisitionLinksSerializer.
 */@ApiModel(description = "RequisitionLinksSerializer.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2023-02-25T17:56:18.166387600+01:00[Europe/Warsaw]")
public class RequisitionLinks {

  
  @JsonProperty("initiate")
  private String initiate = null;
  
  
  /**
  * Get initiate
  * @return initiate
  **/
  @ApiModelProperty(value = "")
  public String getInitiate() {
    return initiate;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequisitionLinks requisitionLinks = (RequisitionLinks) o;
    return Objects.equals(this.initiate, requisitionLinks.initiate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initiate);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequisitionLinks {\n");
    
    sb.append("    initiate: ").append(toIndentedString(initiate)).append("\n");
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


