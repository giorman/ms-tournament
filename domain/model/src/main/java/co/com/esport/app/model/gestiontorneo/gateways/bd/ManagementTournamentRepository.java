package co.com.esport.app.model.gestiontorneo.gateways.bd;

import co.com.esport.app.model.gestiontorneo.request.Category;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ManagementTournamentRepository {

    public Mono<TournamentRq> save(TournamentRq tournamentRq);

    public Flux<TournamentRq> findAll();

    public Mono<TournamentRq> findByName(String name);
}
