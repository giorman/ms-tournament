package co.com.esport.app.usecase.creartorneo;

import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ManagementTournamentUseCase {

    //se crea el metodo para crear un torneo
    public static Mono<TournamentRq> crearTorneo(TournamentRq tournamentRq) {
        //se crea el torneo
        return Mono.just(tournamentRq);
    }
}
