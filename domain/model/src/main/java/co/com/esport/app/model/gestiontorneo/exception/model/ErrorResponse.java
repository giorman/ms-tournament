package co.com.esport.app.model.gestiontorneo.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private MetaDTO meta;
    private Error error;

    @lombok.Data
    @Builder
    public static class Error {
        private String code;
        private String message;
    }
}


