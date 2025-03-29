package co.com.esport.app.api.filter;

import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.model.gestiontorneo.exception.ConstantException;
import co.com.esport.app.model.gestiontorneo.exception.ContractException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BodyValidation {

    public Mono<TournamentRqDto> BodyCreate(TournamentRqDto request) {
        return Mono.just(request)
                .doOnNext(this::validateFields)

                .map(tournamentRqDto -> request);
    }

    private void validateFields(TournamentRqDto tournamentRqDto) {
        if (tournamentRqDto == null || tournamentRqDto.getData() == null) {
            throw new ContractException(ConstantException.DATA_ERROR);
        }

        TournamentRqDto.Data data = tournamentRqDto.getData();
        if (isNullOrEmpty(data.getTournamentName()) ||
                isNullOrEmpty(data.getDescription()) ||
                isNullOrEmpty(data.getGame()) ||
                isNullOrEmpty(data.getCategory()) ||
                isNullOrEmpty(data.getStreamingPlatform()) ||
                data.getPrizes() == null || data.getPrizes().isEmpty() ||
                data.getSalesStages() == null || data.getSalesStages().isEmpty() ||
                data.getStartDate() == null ||
                data.getEndDate() == null ||
                data.getOrganizer() == null ||
                isNullOrEmpty(data.getOrganizer().getId())) {
            throw new ContractException(ConstantException.DATA_ERROR);
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}