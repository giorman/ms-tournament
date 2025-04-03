package co.com.esport.app.mongo.repositories.tournament;

import co.com.esport.app.model.gestiontorneo.gateways.bd.ManagementTournamentRepository;
import co.com.esport.app.model.gestiontorneo.request.Category;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import co.com.esport.app.mongo.entity.TournamentEntity;
import co.com.esport.app.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryTournamentAdapter extends AdapterOperations<TournamentRq/* change for domain model */, TournamentEntity/* change for adapter model */, String, MongoDBTournamentRepository> implements ManagementTournamentRepository

// implements ModelRepository from domain
{

    public MongoRepositoryTournamentAdapter(MongoDBTournamentRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, TournamentRq.class/* change for domain model */));
    }


    @Override
    public Mono<Long> countByStatusAndFreeAndIdOrganizer(String status, boolean free, String idOrganizer) {
        return repository.countByStatusAndFreeAndIdOrganizer(status, free, idOrganizer);
    }

    @Override
    public Mono<TournamentRq> findByIdAndIdOrganizer(String id, String idOrganizer) {
        return repository.findByIdAndIdOrganizer(id, idOrganizer)
                .map(tournamentEntity -> mapper.map(tournamentEntity, TournamentRq.class));
    }


}
