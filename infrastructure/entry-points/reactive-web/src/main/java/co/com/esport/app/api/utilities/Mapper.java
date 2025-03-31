package co.com.esport.app.api.utilities;


import co.com.esport.app.api.dtos.commons.MetaDTO;
import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.api.dtos.response.CreateTournamentRsDTO;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import co.com.esport.app.model.gestiontorneo.response.CreateTournamentRs;
import co.com.esport.app.model.gestiontorneo.utils.Status;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    //metodo para mapear de TournamentDTO a TournamentRq
    public TournamentRq mapToTournamentRq(TournamentRqDto tournamentRqDto , ServerRequest serverRequest){

        return TournamentRq.builder()
                .messageId(serverRequest.headers().firstHeader("message-id"))
                .name(tournamentRqDto.getData().getTournamentName())
                .game(tournamentRqDto.getData().getGame())
                .description(tournamentRqDto.getData().getDescription())
                .idOrganizer(tournamentRqDto.getData().getOrganizer().getId())
                .streamingPlatform(tournamentRqDto.getData().getStreamingPlatform())
                .status(Status.ACTIVE.getStatus())
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

    public CreateTournamentRsDTO mapToCreateTournamentRsDTO(CreateTournamentRs createTournamentRs, ServerRequest.Headers headers , String requestDateTime) {
        return CreateTournamentRsDTO.builder()
                .meta(MetaDTO.builder()
                        .messageId(headers.firstHeader("message-id"))
                        .requestDateTime(requestDateTime)
                        .build())
                .data(CreateTournamentRsDTO.Data.builder()
                        .idTournament(createTournamentRs.getIdTournament())
                        .nameTournament(createTournamentRs.getNameTournament())
                        .build())
                .build();
    }


    private ArrayList<TournamentRq.Prizes> mapToPrizes(List<TournamentRqDto.Data.Prizes> prizes) {
        return prizes.stream()
                .map(prize -> new TournamentRq.Prizes(prize.getPrize()))
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
