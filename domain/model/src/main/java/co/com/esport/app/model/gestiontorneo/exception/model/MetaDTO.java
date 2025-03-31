package co.com.esport.app.model.gestiontorneo.exception.model;

//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaDTO {
//    @JsonProperty("_messageId")
    private String messageId;
//    @JsonProperty("_requestDateTime")
    private String requestDateTime;
}
