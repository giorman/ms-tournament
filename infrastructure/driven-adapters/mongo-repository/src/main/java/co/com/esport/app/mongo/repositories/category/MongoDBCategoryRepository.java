package co.com.esport.app.mongo.repositories.category;

import co.com.esport.app.mongo.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Mono;

public interface MongoDBCategoryRepository extends ReactiveMongoRepository<CategoryEntity/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<CategoryEntity/* change for adapter model */> {
     Mono<CategoryEntity> findByName(String name);
}
