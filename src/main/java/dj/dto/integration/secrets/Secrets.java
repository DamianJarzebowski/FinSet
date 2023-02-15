package dj.dto.integration.secrets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Accessors(chain = true)
public class Secrets implements Serializable {

    @JsonProperty("secret_id")
    private String secretId;

    @JsonProperty("secret_key")
    private String secretKey;
}
