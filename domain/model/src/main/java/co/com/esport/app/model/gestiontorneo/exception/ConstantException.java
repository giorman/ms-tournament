package co.com.esport.app.model.gestiontorneo.exception;

import co.com.esport.app.model.gestiontorneo.exception.model.CodeMessage;
import co.com.esport.app.model.gestiontorneo.exception.model.ErrorManagment;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ConstantException implements ErrorManagment {

    UNKNOWN_ERROR(
            CodeMessage.UNKNOWN_ERROR_DETAIL),
    MESSAGEID_ERROR(
            CodeMessage.INVALID_MESSAGEID),
    DATA_ERROR(
            CodeMessage.BODY_DATA_REQUIRED);

    private final String message;



}
