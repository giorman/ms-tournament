package co.com.esport.app.model.gestiontorneo.exception.model;

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
            CodeMessage.BODY_DATA_REQUIRED),
    STATUS_ERROR(
            CodeMessage.STATUS_INVALID),
    CATEGORY_INVALID(
            CodeMessage.CATEGORY_NOT_FOUND);

    private final String message;



}
