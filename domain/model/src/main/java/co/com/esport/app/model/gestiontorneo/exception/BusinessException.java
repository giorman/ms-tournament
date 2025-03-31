package co.com.esport.app.model.gestiontorneo.exception;

import co.com.esport.app.model.gestiontorneo.exception.model.ConstantException;

public class BusinessException extends RuntimeException{

    public BusinessException(ConstantException message) {
        super(validateMessage(message).getMessage());
    }

    private static ConstantException validateMessage(ConstantException message) {
        return (message == null)
                ? ConstantException.UNKNOWN_ERROR
                : message;
    }
}
