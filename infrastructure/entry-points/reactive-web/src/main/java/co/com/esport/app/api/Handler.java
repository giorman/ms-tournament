package co.com.esport.app.api;

import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.api.filter.BodyValidation;
import co.com.esport.app.api.filter.HeadersValidation;
import co.com.esport.app.api.utilities.Mapper;
import co.com.esport.app.usecase.creartorneo.ManagementTournamentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class Handler {
    private final HeadersValidation headersValidation;
    private final BodyValidation tournamentValidation;
    private final ManagementTournamentUseCase managementTournamentUseCase;
    private final Mapper mapper;
//private  final UseCase2 useCase2;

    public Mono<ServerResponse> createTournament(ServerRequest serverRequest) {
        String requestDateTime = Instant.now().toString();
        return serverRequest
                .bodyToMono(TournamentRqDto.class)
                .flatMap(tournamentValidation::BodyCreate)
                .flatMap(dto -> headersValidation.validateHeaders(serverRequest)
                        .then(Mono.just(dto)))
                .map(dto -> mapper.mapToTournamentRq(dto, serverRequest))
                .flatMap(managementTournamentUseCase::createTournament)
                .flatMap(dto -> Mono.just(mapper.mapToCreateTournamentRsDTO(dto, serverRequest.headers(), requestDateTime)))
                .flatMap(response -> ServerResponse.created(URI.create("/v1/api/ms-tournament/create/".concat(response.getData().getIdTournament()))).bodyValue(response));
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
