package co.com.esport.app.usecase.creartorneo;

import co.com.esport.app.model.gestiontorneo.gateways.ManagementTournamentRepository;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import co.com.esport.app.model.gestiontorneo.response.CreateTournamentRs;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class ManagementTournamentUseCase {

 private final ManagementTournamentRepository managementTournamentRepository;


    //se crea el metodo para crear un torneo
    public  Mono<CreateTournamentRs> crearTorneo(TournamentRq tournamentRq) {
        return managementTournamentRepository.save(tournamentRq)
                .doOnNext(tournament -> {
                    if (tournament.getIdOrganizer() == null) {
                        throw new RuntimeException("Error al crear el torneo");
                    }
                })
                .map(this::mapToCreateTournamentRs);
    }


//se crea el metodo para mapear el torneo
    public CreateTournamentRs mapToCreateTournamentRs(TournamentRq tournamentRq) {

        return CreateTournamentRs.builder()
                .idTournament(tournamentRq.getId())
                .nameTournament(tournamentRq.getName())
                .build();
    }

}
