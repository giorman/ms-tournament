package co.com.esport.app.api;

import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.api.utilities.Mapper;
import co.com.esport.app.usecase.creartorneo.ManagementTournamentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final ManagementTournamentUseCase managementTournamentUseCase;
    private final Mapper mapper;
//private  final UseCase2 useCase2;

    public Mono<ServerResponse> crearTorneo(ServerRequest serverRequest) {


        //recibe el objeto de la petición y lo mapea a un objeto de tipo TournamentRqDto y lo retorna.


        return serverRequest.bodyToMono(TournamentRqDto.class)
                .map(dto -> mapper.mapToTournamentRq(dto , serverRequest))
                .flatMap(ManagementTournamentUseCase::crearTorneo)
                .flatMap(dto -> ServerResponse.ok().bodyValue(dto));
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
