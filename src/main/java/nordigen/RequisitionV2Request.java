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
import java.util.UUID;

/**
 * RequisitionV2Serializer.
 */@ApiModel(description = "RequisitionV2Serializer.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2023-02-25T17:56:18.166387600+01:00[Europe/Warsaw]")
public class RequisitionV2Request {

  
  @JsonProperty("redirect")
  private String redirect = null;
  
  
  @JsonProperty("institution_id")
  private String institutionId = null;
  
  
  @JsonProperty("agreement")
  private UUID agreement = null;
  
  
  @JsonProperty("reference")
  private String reference = null;
  
  
  @JsonProperty("user_language")
  private String userLanguage = null;
  
  
  @JsonProperty("ssn")
  private String ssn = null;
  
  
  @JsonProperty("account_selection")
  private Boolean accountSelection = false;
  
  
  @JsonProperty("redirect_immediate")
  private Boolean redirectImmediate = false;
  
  public RequisitionV2Request redirect(String redirect) {
    this.redirect = redirect;
    return this;
  }

  
  /**
  * redirect URL to your application after end-user authorization with ASPSP
  * @return redirect
  **/
  @ApiModelProperty(required = true, value = "redirect URL to your application after end-user authorization with ASPSP")
  public String getRedirect() {
    return redirect;
  }
  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }
  
  public RequisitionV2Request institutionId(String institutionId) {
    this.institutionId = institutionId;
    return this;
  }

  
  /**
  * an Institution ID for this Requisition
  * @return institutionId
  **/
  @ApiModelProperty(required = true, value = "an Institution ID for this Requisition")
  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  
  public RequisitionV2Request agreement(UUID agreement) {
    this.agreement = agreement;
    return this;
  }

  
  /**
  * EUA associated with this requisition
  * @return agreement
  **/
  @ApiModelProperty(value = "EUA associated with this requisition")
  public UUID getAgreement() {
    return agreement;
  }
  public void setAgreement(UUID agreement) {
    this.agreement = agreement;
  }
  
  public RequisitionV2Request reference(String reference) {
    this.reference = reference;
    return this;
  }

  
  /**
  * additional ID to identify the end user
  * @return reference
  **/
  @ApiModelProperty(value = "additional ID to identify the end user")
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }
  
  public RequisitionV2Request userLanguage(String userLanguage) {
    this.userLanguage = userLanguage;
    return this;
  }

  
  /**
  * A two-letter country code (ISO 639-1)
  * @return userLanguage
  **/
  @ApiModelProperty(value = "A two-letter country code (ISO 639-1)")
  public String getUserLanguage() {
    return userLanguage;
  }
  public void setUserLanguage(String userLanguage) {
    this.userLanguage = userLanguage;
  }
  
  public RequisitionV2Request ssn(String ssn) {
    this.ssn = ssn;
    return this;
  }

  
  /**
  * optional SSN field to verify ownership of the account
  * @return ssn
  **/
  @ApiModelProperty(value = "optional SSN field to verify ownership of the account")
  public String getSsn() {
    return ssn;
  }
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }
  
  public RequisitionV2Request accountSelection(Boolean accountSelection) {
    this.accountSelection = accountSelection;
    return this;
  }

  
  /**
  * option to enable account selection view for the end user
  * @return accountSelection
  **/
  @ApiModelProperty(value = "option to enable account selection view for the end user")
  public Boolean isAccountSelection() {
    return accountSelection;
  }
  public void setAccountSelection(Boolean accountSelection) {
    this.accountSelection = accountSelection;
  }
  
  public RequisitionV2Request redirectImmediate(Boolean redirectImmediate) {
    this.redirectImmediate = redirectImmediate;
    return this;
  }

  
  /**
  * enable redirect back to the client after account list received
  * @return redirectImmediate
  **/
  @ApiModelProperty(value = "enable redirect back to the client after account list received")
  public Boolean isRedirectImmediate() {
    return redirectImmediate;
  }
  public void setRedirectImmediate(Boolean redirectImmediate) {
    this.redirectImmediate = redirectImmediate;
  }
  
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequisitionV2Request requisitionV2Request = (RequisitionV2Request) o;
    return Objects.equals(this.redirect, requisitionV2Request.redirect) &&
        Objects.equals(this.institutionId, requisitionV2Request.institutionId) &&
        Objects.equals(this.agreement, requisitionV2Request.agreement) &&
        Objects.equals(this.reference, requisitionV2Request.reference) &&
        Objects.equals(this.userLanguage, requisitionV2Request.userLanguage) &&
        Objects.equals(this.ssn, requisitionV2Request.ssn) &&
        Objects.equals(this.accountSelection, requisitionV2Request.accountSelection) &&
        Objects.equals(this.redirectImmediate, requisitionV2Request.redirectImmediate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(redirect, institutionId, agreement, reference, userLanguage, ssn, accountSelection, redirectImmediate);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequisitionV2Request {\n");
    
    sb.append("    redirect: ").append(toIndentedString(redirect)).append("\n");
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    userLanguage: ").append(toIndentedString(userLanguage)).append("\n");
    sb.append("    ssn: ").append(toIndentedString(ssn)).append("\n");
    sb.append("    accountSelection: ").append(toIndentedString(accountSelection)).append("\n");
    sb.append("    redirectImmediate: ").append(toIndentedString(redirectImmediate)).append("\n");
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



