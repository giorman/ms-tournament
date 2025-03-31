package co.com.esport.app.usecase.creartorneo;

import co.com.esport.app.model.gestiontorneo.exception.BusinessException;
import co.com.esport.app.model.gestiontorneo.exception.model.ConstantException;
import co.com.esport.app.model.gestiontorneo.gateways.bd.ManagementCategoryRepository;
import co.com.esport.app.model.gestiontorneo.gateways.bd.ManagementTournamentRepository;
import co.com.esport.app.model.gestiontorneo.request.Category;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import co.com.esport.app.model.gestiontorneo.response.CreateTournamentRs;
import co.com.esport.app.model.gestiontorneo.utils.Status;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class ManagementTournamentUseCase {

    private final ManagementTournamentRepository managementTournamentRepository;
    private final ManagementCategoryRepository managementCategoryRepository;


    //se crea el metodo para crear un tor neorcggddggdddaloh
    public Mono<CreateTournamentRs> createTournament(TournamentRq tournamentRq) {

        isValidStatus(tournamentRq.getStatus());
//        isValidCategory(tournamentRq.getCategory());

        return managementCategoryRepository.findByName(tournamentRq.getCategory())
                .switchIfEmpty(Mono.error(new BusinessException(ConstantException.CATEGORY_INVALID)))
                .then(managementTournamentRepository.save(tournamentRq))
                .doOnNext(tournament -> {
                    if (tournament.getIdOrganizer() == null) {
                        throw new RuntimeException("Error al crear el torneo");
                    }
                })
                .map(this::mapToCreateTournamentRs);
    }

    //metodo que me permita validar si el estado del torneo coresponde a los validos del enum status
    public void isValidStatus(String status) {
        if (!Status.isValidStatus(status)) {
            throw new BusinessException(ConstantException.STATUS_ERROR);
        }

    }

    //metodo que me permita validar si la categoria de la existe en la base de datos
    public void isValidCategory(String category) {
        System.out.println("se entro a validar la categoria");

        managementTournamentRepository.save(TournamentRq.builder()
                        .name("prueba")
                        .description("descripcion")
                        .build())
                .doOnNext(category1 -> {
                    System.out.println("Torneo encontrada: " + category1.getDescription());
                })
                .switchIfEmpty(
                        Mono.error(new BusinessException(ConstantException.CATEGORY_INVALID))
                );

        managementCategoryRepository.save(Category.builder()
                .name("nueva")
                .description("descripcion")
                .build());


        managementCategoryRepository.findByName(category)
                .doOnNext(category1 -> {
                    System.out.println("Categoria encontrada: " + category1.getName());
                })
                .switchIfEmpty(
                        Mono.error(new BusinessException(ConstantException.CATEGORY_INVALID))
                );

    }


    //se crea el metodo para mapear el torneo
    public CreateTournamentRs mapToCreateTournamentRs(TournamentRq tournamentRq) {

        return CreateTournamentRs.builder()
                .idTournament(tournamentRq.getId())
                .nameTournament(tournamentRq.getName())
                .build();
    }

}