package co.com.esport.app.mongo;

import co.com.esport.app.mongo.entity.TournamentEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<TournamentEntity/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<TournamentEntity/* change for adapter model */> {
}
