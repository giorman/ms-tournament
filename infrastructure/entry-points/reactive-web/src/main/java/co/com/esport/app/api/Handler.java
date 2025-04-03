package co.com.esport.app.api;

import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.api.filter.BodyValidation;
import co.com.esport.app.api.filter.HeadersValidation;
import co.com.esport.app.api.utilities.Mapper;
import co.com.esport.app.usecase.creartorneo.ManagementTournamentUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class Handler {
    private final HeadersValidation headersValidation;
    private final BodyValidation tournamentValidation;
    private final ManagementTournamentUseCase managementTournamentUseCase;
    private final Mapper mapper;


    public Mono<ServerResponse> createTournament(ServerRequest serverRequest) {

        return serverRequest
                .bodyToMono(TournamentRqDto.class)
                .doOnNext(tournamentRqDto -> {
                    mapper.mapToLog(tournamentRqDto, serverRequest);
                })
                .flatMap(tournamentValidation::BodyCreate)
                .flatMap(dto -> headersValidation.validateHeaders(serverRequest)
                        .then(Mono.just(dto)))
                .map(mapper::mapToTournamentRq)
                .flatMap(managementTournamentUseCase::createTournament)
                .flatMap(dto -> Mono.just(mapper.mapToTournamentRsDTO(dto, serverRequest)))
                .flatMap(response -> ServerResponse.created(URI.create("/v1/api/ms-tournament/create/".concat(response.getData().getIdTournament()))).bodyValue(response));
    }

    public Mono<ServerResponse> updateTournament(ServerRequest serverRequest) {

        return serverRequest
                .bodyToMono(TournamentRqDto.class)
                .doOnNext(tournamentRqDto -> {
                  mapper.mapToLog(tournamentRqDto, serverRequest);
                })
                .flatMap(tournamentValidation::BodyUpdate)
                .flatMap(dto -> headersValidation.validateHeaders(serverRequest)
                        .then(Mono.just(dto)))
                .map(mapper::mapToTournamentRq)
                .flatMap(managementTournamentUseCase::updateTournament)
                .flatMap(dto -> Mono.just(mapper.mapToTournamentRsDTO(dto, serverRequest)))
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }




}
