package dj.dto.integration;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "institution_id",
        "max_historical_days",
        "access_valid_for_days",
        "access_scope"
})
@Data
@Accessors(chain = true)
public class IntegrationForm {

    @JsonProperty("institution_id")
    public String institutionId;

    @JsonProperty("max_historical_days")
    public String maxHistoricalDays;

    @JsonProperty("access_valid_for_days")
    public String accessValidForDays;

    @JsonProperty("access_scope")
    public List<String> accessScope = new ArrayList<String>();

}