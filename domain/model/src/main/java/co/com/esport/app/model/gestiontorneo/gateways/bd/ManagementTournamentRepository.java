package co.com.esport.app.model.gestiontorneo.gateways.bd;

import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ManagementTournamentRepository {

    Mono<TournamentRq> save(TournamentRq tournamentRq);

    Mono<Long> countByStatusAndFreeAndIdOrganizer(String status, boolean free, String idOrganizer);

    Mono<TournamentRq> findById(String id);

}
