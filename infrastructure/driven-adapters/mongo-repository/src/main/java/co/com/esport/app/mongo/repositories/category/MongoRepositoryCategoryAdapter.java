package co.com.esport.app.mongo.repositories.category;

import co.com.esport.app.model.gestiontorneo.gateways.bd.ManagementCategoryRepository;
import co.com.esport.app.model.gestiontorneo.request.Category;
import co.com.esport.app.mongo.entity.CategoryEntity;
import co.com.esport.app.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryCategoryAdapter extends AdapterOperations<Category/* change for domain model */, CategoryEntity/* change for adapter model */, String, MongoDBCategoryRepository> implements ManagementCategoryRepository

// implements ModelRepository from domain
{

    public MongoRepositoryCategoryAdapter(MongoDBCategoryRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Category.class/* change for domain model */));
    }


    @Override
    public Mono<Category> findByName(String name) {
        return repository.findByName(name)
                .map(entity -> mapper.map(entity, Category.class));
    }
}
