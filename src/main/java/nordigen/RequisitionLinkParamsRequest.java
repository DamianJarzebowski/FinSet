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
 * RequisitionLinkParamsSerializer.
 */@ApiModel(description = "RequisitionLinkParamsSerializer.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2023-02-25T17:56:18.166387600+01:00[Europe/Warsaw]")
public class RequisitionLinkParamsRequest {

  
  @JsonProperty("aspsp_id")
  private String aspspId = null;
  
  public RequisitionLinkParamsRequest aspspId(String aspspId) {
    this.aspspId = aspspId;
    return this;
  }

  
  /**
  * ASPSP ID. Should match one used while creating EUA, if it&#x27;s linked to this requisition
  * @return aspspId
  **/
  @ApiModelProperty(required = true, value = "ASPSP ID. Should match one used while creating EUA, if it's linked to this requisition")
  public String getAspspId() {
    return aspspId;
  }
  public void setAspspId(String aspspId) {
    this.aspspId = aspspId;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequisitionLinkParamsRequest requisitionLinkParamsRequest = (RequisitionLinkParamsRequest) o;
    return Objects.equals(this.aspspId, requisitionLinkParamsRequest.aspspId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aspspId);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequisitionLinkParamsRequest {\n");
    
    sb.append("    aspspId: ").append(toIndentedString(aspspId)).append("\n");
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



