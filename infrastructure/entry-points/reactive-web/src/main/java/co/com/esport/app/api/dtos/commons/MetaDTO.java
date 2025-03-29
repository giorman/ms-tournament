package co.com.esport.app.api.dtos.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaDTO {
    @JsonProperty("_messageId")
    private String messageId;
    @JsonProperty("_requestDateTime")
    private String requestDateTime;
}
