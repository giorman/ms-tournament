package co.com.esport.app.api.filter;


import co.com.esport.app.model.gestiontorneo.exception.ConstantException;
import co.com.esport.app.model.gestiontorneo.exception.ContractException;
import co.com.esport.app.model.gestiontorneo.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

@Service
public class HeadersValidation {


    public Mono<Void> validateHeaders(ServerRequest request) {

        String messageId = request.headers().firstHeader(Constants.MESSAGE_ID_HEADER);

        if (!validateUUID(messageId) || messageId == null || messageId.isBlank()) {
            return Mono.error(() -> new ContractException(ConstantException.MESSAGEID_ERROR));
        }
     return Mono.empty();

    }

    private boolean validateUUID(String uuid) {
        return uuid != null && Constants.REGEX_UUID_PATTERN.matcher(uuid).matches();
    }

    private boolean validationAid(String alias) {
        return alias != null && Constants.REGEX_AID_PATTERN.matcher(alias).matches();
    }
}
