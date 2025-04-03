package co.com.esport.app.usecase.creartorneo;

import co.com.esport.app.model.gestiontorneo.exception.BusinessException;
import co.com.esport.app.model.gestiontorneo.exception.SystemException;
import co.com.esport.app.model.gestiontorneo.exception.model.ConstantException;
import co.com.esport.app.model.gestiontorneo.gateways.bd.ManagementCategoryRepository;
import co.com.esport.app.model.gestiontorneo.gateways.bd.ManagementTournamentRepository;
import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import co.com.esport.app.model.gestiontorneo.response.TournamentRs;
import co.com.esport.app.model.gestiontorneo.utils.Platform;
import co.com.esport.app.model.gestiontorneo.utils.Status;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class ManagementTournamentUseCase {

    private final ManagementTournamentRepository managementTournamentRepository;
    private final ManagementCategoryRepository managementCategoryRepository;


    //se crea el metodo para crear un torneo
    public Mono<TournamentRs> createTournament(TournamentRq tournamentRq) {

        tournamentRq.setStatus(Status.ACTIVE.getStatus());
        isValidPlatform(tournamentRq.getStreamingPlatform());

        if (!tournamentRq.getFree()) {
            validatePay(tournamentRq);
        }

        validateLimitCordinator(tournamentRq);
        validateLimitPrizes(tournamentRq);
        validateLimitSalesStages(tournamentRq);

        return managementCategoryRepository.findByName(tournamentRq.getCategory())
                .switchIfEmpty(Mono.error(new BusinessException(ConstantException.CATEGORY_INVALID)))// Simulate a delay of 2 seconds
                .flatMap(category -> {
                    if (tournamentRq.getFree() && category.getCapacity().getPlayers() < tournamentRq.getNumberPlayers()) {
                        return Mono.error(new BusinessException(ConstantException.PLAYERS_LIMIT_EXCEEDED));
                    }
                    return Mono.empty();
                })
                .then(managementTournamentRepository.countByStatusAndFreeAndIdOrganizer(Status.ACTIVE.getStatus(), true, tournamentRq.getIdOrganizer()))
                .flatMap(count -> {
                    if (count >= 2 && tournamentRq.getFree()) {

                        return Mono.error(new BusinessException(ConstantException.TOURNEY_LIMIT_EXCEEDED));
                    }
                        return Mono.empty();

                })
                .then(managementTournamentRepository.save(tournamentRq))
                .switchIfEmpty(Mono.error(new SystemException(ConstantException.CREATE_ERROR)))
                .map(this::mapToTournamentRs);
    }


    public Mono<TournamentRs> updateTournament(TournamentRq tournamentRq) {

        isValidStatus(tournamentRq.getStatus());
        isValidPlatform(tournamentRq.getStreamingPlatform());

        if (!tournamentRq.getFree()) {

            validatePay(tournamentRq);
        }
        validateLimitCordinator(tournamentRq);
        validateLimitPrizes(tournamentRq);
        validateLimitSalesStages(tournamentRq);

        return managementTournamentRepository.findById(tournamentRq.getId())
                .switchIfEmpty(Mono.error(new BusinessException(ConstantException.TOURNAMENT_NOT_FOUND)))
                .flatMap(existingTournament -> managementCategoryRepository.findByName(tournamentRq.getCategory())
                        .switchIfEmpty(Mono.error(new BusinessException(ConstantException.CATEGORY_INVALID)))
                        .flatMap(category -> {
                            if (tournamentRq.getFree() && category.getCapacity().getPlayers() < tournamentRq.getNumberPlayers()) {
                                return Mono.error(new BusinessException(ConstantException.PLAYERS_LIMIT_EXCEEDED));
                            }
                            return Mono.empty();
                        })
                        .flatMap(mono -> managementTournamentRepository.countByStatusAndFreeAndIdOrganizer(Status.ACTIVE.getStatus(), true, tournamentRq.getIdOrganizer())
                                .flatMap(count -> {
                                    if (count >= 2 && tournamentRq.getFree()) {
                                        return Mono.error(new BusinessException(ConstantException.TOURNEY_LIMIT_EXCEEDED));
                                    }
                                    return Mono.empty();
                                })
                        )
                        .then(managementTournamentRepository.save(tournamentRq))
                        .switchIfEmpty(Mono.error(new SystemException(ConstantException.UPDATE_ERROR)))
                        .map(this::mapToTournamentRs)
                );
    }

    //metodo que me permita validar si el estado del torneo coresponde a los validos del enum status
    public void isValidStatus(String status) {
        if (!Status.isValidStatus(status)) {
            throw new BusinessException(ConstantException.STATUS_ERROR);
        }
    }

    //metodo para validar si la platform del torneo corresponde a los validos del enum platform
    public void isValidPlatform(String platform) {
        if (!Platform.isValidPlatform(platform)) {
            throw new BusinessException(ConstantException.PLATFORM_ERROR);
        }
    }

   //metodo para validar si el parametro salesStages es nulo o vacio
    public void validatePay(TournamentRq tournamentRq) {
    //validar si salesStages es nulo o vacio
        if (tournamentRq.getSalesStages() == null || tournamentRq.getSalesStages().isEmpty()) {
            throw new BusinessException(ConstantException.SALES_STAGES_NULL);
        }
    }

    //metodo para validar el limite de coordinadores
    public void validateLimitCordinator(TournamentRq tournamentRq) {
        if (tournamentRq.getCordinator() != null && tournamentRq.getCordinator().size() > 2) {
            throw new BusinessException(ConstantException.CORDINATOR_LIMIT_EXCEEDED);
        }
    }

    //metodo para validar el limite de premios
    public void validateLimitPrizes(TournamentRq tournamentRq) {
        if (tournamentRq.getPrizes()!= null && tournamentRq.getPrizes().size() > 3) {
            throw new BusinessException(ConstantException.PRIZES_LIMIT_EXCEEDED);
        }
    }

    //metodo para validar el limite de etapas de venta
    public void validateLimitSalesStages(TournamentRq tournamentRq) {
        if (tournamentRq.getSalesStages()!= null && tournamentRq.getSalesStages().size() > 3) {
            throw new BusinessException(ConstantException.SALESSTAGES_LIMIT_EXCEEDED);
        }
    }

    //se crea el metodo para mapear el torneo
    public TournamentRs mapToTournamentRs(TournamentRq tournamentRq) {

        return TournamentRs.builder()
                .idTournament(tournamentRq.getId())
                .nameTournament(tournamentRq.getName())
                .build();
    }



}