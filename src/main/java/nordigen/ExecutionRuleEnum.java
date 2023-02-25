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



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;



/**
 * Gets or Sets ExecutionRuleEnum
 */

public enum ExecutionRuleEnum {
  
  FOLLOWING("following"),
  
  PRECEDING("preceding");

  private String value;

  ExecutionRuleEnum(String value) {
    this.value = value;
  }


  @JsonValue

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }


  @JsonCreator

  public static ExecutionRuleEnum fromValue(String text) {
    for (ExecutionRuleEnum b : ExecutionRuleEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

}


