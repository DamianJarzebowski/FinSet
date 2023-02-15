
package dj.dto.integration.build_a_link;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Accessors(chain = true)
public class ResponseEndingIntegration {

    @JsonProperty("id")
    public String id;

    @JsonProperty("redirect")
    public String redirect;

    @JsonProperty("status")
    public Status status;

    @JsonProperty("agreements")
    public String agreements;

    @JsonProperty("accounts")
    public List<Object> accounts = new ArrayList<>();

    @JsonProperty("reference")
    public String reference;

    @JsonProperty("user_language")
    public String userLanguage;

    @JsonProperty("link")
    public String link;

}
