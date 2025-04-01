package co.com.esport.app.api.utilities;

import co.com.esport.app.model.gestiontorneo.exception.BusinessException;
import co.com.esport.app.model.gestiontorneo.exception.ContractException;
import co.com.esport.app.model.gestiontorneo.exception.SystemException;
import co.com.esport.app.model.gestiontorneo.exception.model.ConstantException;
import co.com.esport.app.model.gestiontorneo.exception.model.ErrorResponse;
import co.com.esport.app.model.gestiontorneo.exception.model.MetaDTO;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import org.springframework.web.reactive.result.view.ViewResolver;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;

@Component
public class HandlerExceptionsGlobal extends AbstractErrorWebExceptionHandler {

    public HandlerExceptionsGlobal(ErrorAttributes errorAttributes,
                                   WebProperties.Resources resources,
                                   ApplicationContext applicationContext,
                                   ServerCodecConfigurer serverCodecConfigurer,
                                   List<ViewResolver> viewResolvers) {
        super(errorAttributes, resources, applicationContext);
        super.setMessageWriters(serverCodecConfigurer.getWriters());
        super.setMessageReaders(serverCodecConfigurer.getReaders());
        super.setViewResolvers(viewResolvers);
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::handlerError);
    }

    private Mono<ServerResponse> handlerError(ServerRequest request) {
        Throwable error = super.getError(request);
        HttpStatus status;
        String mensaje;
        String errorCode = "";

        if (error instanceof ContractException) {
            status = HttpStatus.BAD_REQUEST;
            mensaje = error.getMessage();
            errorCode = "SA".concat(String.valueOf(status.value()));
        } else if (error instanceof BusinessException) {
            status = HttpStatus.CONFLICT;
            mensaje = error.getMessage();
            errorCode = "BP".concat(String.valueOf(status.value()));
        }else if (error instanceof SystemException) {
            status = HttpStatus.BAD_REQUEST;
            mensaje = error.getMessage();
            errorCode = "SI".concat(String.valueOf(status.value()));
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            mensaje = ConstantException.UNKNOWN_ERROR.getMessage();
            errorCode = "SP".concat(String.valueOf(status.value()));
        }

        String messageId = request.attribute("message-id").orElse("default-message-id").toString();
        String requestTime = request.attribute("request-time").orElse(Instant.now().toString()).toString();

        return ServerResponse.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(
                        ErrorResponse.builder()
                                .meta(MetaDTO.builder()
                                        .messageId(messageId)
                                        .requestDateTime(requestTime)
                                        .build())
                                .error(ErrorResponse.Error.builder()
                                        .code(errorCode)
                                        .message(mensaje)
                                        .build())
                                .build()));
    }
}