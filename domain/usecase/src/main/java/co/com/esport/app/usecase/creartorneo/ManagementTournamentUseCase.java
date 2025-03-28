package co.com.esport.app.usecase.creartorneo;

import co.com.esport.app.model.gestiontorneo.gateways.ManagementTournamentRepository;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@AllArgsConstructor
public class ManagementTournamentUseCase {

 private final ManagementTournamentRepository managementTournamentRepository;


    //se crea el metodo para crear un torneo
    public  Mono<TournamentRq> crearTorneo(TournamentRq tournamentRq) {
        //se crea el torneo
     //se llama al repositorio para crear el torneo
        //se retorna el torneo creado

        return managementTournamentRepository.save(tournamentRq)
                .flatMap(tournament -> {
                    return Mono.just(tournament);
                });
    }
}
