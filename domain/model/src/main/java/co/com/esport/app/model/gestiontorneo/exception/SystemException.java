package co.com.esport.app.model.gestiontorneo.exception;

import co.com.esport.app.model.gestiontorneo.exception.model.ConstantException;

public class SystemException extends RuntimeException{

    public SystemException(ConstantException message) {
        super(validateMessage(message).getMessage());
    }

    private static ConstantException validateMessage(ConstantException message) {
        return (message == null)
                ? ConstantException.UNKNOWN_ERROR
                : message;
    }
}
