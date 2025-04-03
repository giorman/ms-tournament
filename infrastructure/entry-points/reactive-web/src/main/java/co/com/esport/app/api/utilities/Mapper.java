package co.com.esport.app.api.utilities;


import co.com.esport.app.api.dtos.commons.MetaDTO;
import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.api.dtos.response.TournamentRsDTO;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import co.com.esport.app.model.gestiontorneo.response.TournamentRs;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
public class Mapper {

    //metodo para mapear de TournamentDTO a TournamentRq
    public TournamentRq mapToTournamentRq(TournamentRqDto tournamentRqDto ){

        return TournamentRq.builder()
                .id(tournamentRqDto.getData().getId())
                .name(tournamentRqDto.getData().getTournamentName())
                .game(tournamentRqDto.getData().getGame())
                .description(tournamentRqDto.getData().getDescription())
                .idOrganizer(tournamentRqDto.getData().getOrganizer() != null ? tournamentRqDto.getData().getOrganizer().getId() : null)
                .streamingPlatform(tournamentRqDto.getData().getStreamingPlatform())
                .status(tournamentRqDto.getData().getStatus() != null ? tournamentRqDto.getData().getStatus().toUpperCase() : null)
                .startDate(tournamentRqDto.getData().getStartDate())
                .endDate(tournamentRqDto.getData().getEndDate())
                .category(tournamentRqDto.getData().getCategory().toUpperCase())
                .prizes(mapToPrizes(tournamentRqDto.getData().getPrizes()))
                .salesStages(tournamentRqDto.getData().getSalesStages() != null && !tournamentRqDto.getData().getSalesStages().isEmpty() ? mapToSalesStages(tournamentRqDto.getData().getSalesStages()) : new ArrayList<>())
                .cordinator(mapToCordinators(tournamentRqDto.getData().getCordinator()))
                .free(tournamentRqDto.getData().getFree())
                .numberPlayers(tournamentRqDto.getData().getNumberPlayers())
                .build();
    }


    public TournamentRsDTO mapToTournamentRsDTO(TournamentRs tournamentRs, ServerRequest request) {
        return TournamentRsDTO.builder()
                .meta(MetaDTO.builder()
                        .messageId(request.attribute("message-id").orElse("default-message-id").toString())
                        .requestDateTime(request.attribute("request-time").orElse(Instant.now().toString()).toString())
                        .build())
                .data(TournamentRsDTO.Data.builder()
                        .idTournament(tournamentRs.getIdTournament())
                        .nameTournament(tournamentRs.getNameTournament())
                        .build())
                .build();
    }

    public Mono<Void> mapToLog(TournamentRqDto tournamentRqDto, ServerRequest request) {
        log.info("Request Headers: {}", request.headers().asHttpHeaders());
        log.info("Request Path: {}", request.path());
        log.info("Request Body: {}", tournamentRqDto.toString());
        return Mono.empty();
    }


    private ArrayList<TournamentRq.Prizes> mapToPrizes(List<TournamentRqDto.Data.Prizes> prizes) {
        return prizes.stream()
                .map(prize -> TournamentRq.Prizes.builder()
                        .position(prize.getPosition())
                        .prize(prize.getPrize())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //metodo para mapear de lista SaleStageDTO a lista SaleStage
    private ArrayList<TournamentRq.SalesStages> mapToSalesStages(List<TournamentRqDto.Data.SalesStages> salesStages){
        return salesStages.stream()
                .map(saleStage -> TournamentRq.SalesStages.builder()
                        .stageName(saleStage.getStageName())
                        .startDate(saleStage.getStartDate())
                        .endDate(saleStage.getEndDate())
                        .price(saleStage.getPrice())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<TournamentRq.Cordinator> mapToCordinators(List<TournamentRqDto.Data.Cordinator> cordinators) {
        return cordinators.stream()
                .map(cordinator -> TournamentRq.Cordinator.builder()
                        .id(cordinator.getId())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }




}
