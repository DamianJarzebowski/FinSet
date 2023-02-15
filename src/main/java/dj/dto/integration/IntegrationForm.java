package dj.dto.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class IntegrationForm {

    @JsonProperty("institution_id")
    public String institutionId;

    @JsonProperty("max_historical_days")
    public int maxHistoricalDays;

    @JsonProperty("access_valid_for_days")
    public int accessValidForDays;

    @JsonProperty("access_scope")
    public List<String> accessScope = new ArrayList<>();

}
