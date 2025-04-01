package co.com.esport.app.api.dtos.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaDTO {
    private String messageId;
    private String requestDateTime;
}
