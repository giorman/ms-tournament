package co.com.esport.app.api.utilities;

import co.com.esport.app.api.dtos.request.StatusDto;
import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Date;

@Component
public class Mapper {

    //metodo para mapear de TournamentDTO a TournamentRq
    public TournamentRq mapToTournamentRq(TournamentRqDto tournamentRqDto , ServerRequest serverRequest){
        return TournamentRq.builder()
                .messageId(serverRequest.headers().firstHeader("message-id"))
                .name(tournamentRqDto.getData().getName())
                .description(tournamentRqDto.getData().getDescription())
                .game(tournamentRqDto.getData().getGame())
                .idOrganizer(tournamentRqDto.getData().getOrganizer().getId())
                .status(StatusDto.ACTIVE.getStatus())
                .startDate(new Date())
                .idCategory(tournamentRqDto.getData().getCategory().getId())
                .build();
    }

}
