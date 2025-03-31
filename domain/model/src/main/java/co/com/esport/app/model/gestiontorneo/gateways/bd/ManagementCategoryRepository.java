package co.com.esport.app.model.gestiontorneo.gateways.bd;

import co.com.esport.app.model.gestiontorneo.request.Category;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ManagementCategoryRepository {

    //consultar categorias por el name
    public Mono<Category> findByName(String name);

    public Mono<Category> save(Category category);


}
