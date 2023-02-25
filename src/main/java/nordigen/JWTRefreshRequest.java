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
 * Refresh access token.
 */@ApiModel(description = "Refresh access token.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2023-02-25T17:56:18.166387600+01:00[Europe/Warsaw]")
public class JWTRefreshRequest {

  
  @JsonProperty("refresh")
  private String refresh = null;
  
  public JWTRefreshRequest refresh(String refresh) {
    this.refresh = refresh;
    return this;
  }

  
  /**
  * Get refresh
  * @return refresh
  **/
  @ApiModelProperty(required = true, value = "")
  public String getRefresh() {
    return refresh;
  }
  public void setRefresh(String refresh) {
    this.refresh = refresh;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JWTRefreshRequest jwTRefreshRequest = (JWTRefreshRequest) o;
    return Objects.equals(this.refresh, jwTRefreshRequest.refresh);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refresh);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JWTRefreshRequest {\n");
    
    sb.append("    refresh: ").append(toIndentedString(refresh)).append("\n");
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



