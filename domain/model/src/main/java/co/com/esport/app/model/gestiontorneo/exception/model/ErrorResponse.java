package co.com.esport.app.model.gestiontorneo.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private MetaDTO meta;
    private Data data;

    @lombok.Data
    @Builder
    public static class Data {
        private String errorCode;
        private String errorMessage;
    }
}


