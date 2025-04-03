package co.com.esport.app.mongo.repositories.tournament;

import co.com.esport.app.mongo.entity.CategoryEntity;
import co.com.esport.app.mongo.entity.TournamentEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Mono;

import java.nio.channels.FileChannel;

public interface MongoDBTournamentRepository extends ReactiveMongoRepository<TournamentEntity/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<TournamentEntity/* change for adapter model */> {
    Mono<TournamentEntity> findByName(String name);

    Mono<Long> countByStatusAndFreeAndIdOrganizer(String status, boolean free, String idOrganizer);

    Mono<TournamentEntity> findByIdAndIdOrganizer(String id, String idOrganizer);
}
