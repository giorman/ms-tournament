package co.com.esport.app.model.gestiontorneo.gateways;

import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import reactor.core.publisher.Mono;

public interface ManagementTournamentRepository {

    public Mono<TournamentRq> save(TournamentRq tournamentRq);
}
