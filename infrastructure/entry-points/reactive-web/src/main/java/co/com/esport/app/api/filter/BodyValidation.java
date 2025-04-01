package co.com.esport.app.api.filter;

import co.com.esport.app.api.dtos.request.TournamentRqDto;
import co.com.esport.app.model.gestiontorneo.exception.model.ConstantException;
import co.com.esport.app.model.gestiontorneo.exception.ContractException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BodyValidation {

    public Mono<TournamentRqDto> BodyCreate(TournamentRqDto request) {
        return Mono.just(request)
                .doOnNext(this::validateFieldsCreate)
                .map(tournamentRqDto -> request);
    }

    public Mono<TournamentRqDto> BodyUpdate(TournamentRqDto request) {
        return Mono.just(request)
                .doOnNext(this::validateFieldsUpdate)
                .map(tournamentRqDto -> request);
    }

    private void validateFieldsCreate(TournamentRqDto tournamentRqDto) {
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
                data.getStartDate() == null ||
                data.getEndDate() == null ||
                data.getOrganizer() == null ||
                data.getFree() == null ||
                data.getNumberPlayers() == null ||
                isNullOrEmpty(data.getOrganizer().getId())) {
            throw new ContractException(ConstantException.DATA_ERROR);
        }
    }

    private void validateFieldsUpdate(TournamentRqDto tournamentRqDto) {
        if (tournamentRqDto == null || tournamentRqDto.getData() == null) {
            throw new ContractException(ConstantException.DATA_ERROR);
        }

        TournamentRqDto.Data data = tournamentRqDto.getData();
        if (isNullOrEmpty(data.getId()) ||
                isNullOrEmpty(data.getTournamentName()) ||
                isNullOrEmpty(data.getDescription()) ||
                isNullOrEmpty(data.getGame()) ||
                isNullOrEmpty(data.getCategory()) ||
                (data.getStatus() == null || isNullOrEmpty(data.getStatus())) ||
                isNullOrEmpty(data.getStreamingPlatform()) ||
                data.getPrizes() == null || data.getPrizes().isEmpty() ||
                data.getStartDate() == null ||
                data.getEndDate() == null ||
                data.getFree() == null ||
                data.getNumberPlayers() == null ) {
            throw new ContractException(ConstantException.DATA_ERROR);
        }
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}