package co.com.esport.app.api.utilities;


import co.com.esport.app.api.dtos.request.Status;
import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
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
                .category(tournamentRqDto.getData().getCategory())
                .prizes(mapPrizes(tournamentRqDto.getData().getPrizes()))
                .salesStages(mapToSalesStages(tournamentRqDto.getData().getSalesStages()))
                .build();
    }

    private ArrayList<TournamentRq.Prizes> mapPrizes(List<TournamentRqDto.Data.Prizes> prizes) {
        return prizes.stream()
                .map(prize -> new TournamentRq.Prizes(prize.getPrize()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //metodo para mapear de lista SaleStageDTO a lista SaleStage
    public ArrayList<TournamentRq.SalesStages> mapToSalesStages(List<TournamentRqDto.Data.SalesStages> salesStages){
        return salesStages.stream()
                .map(saleStage -> TournamentRq.SalesStages.builder()
                        .stageName(saleStage.getStageName())
                        .startDate(saleStage.getStartDate())
                        .endDate(saleStage.getEndDate())
                        .price(saleStage.getPrice())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
