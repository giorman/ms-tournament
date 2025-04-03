package co.com.esport.app.api.dtos.response;

import co.com.esport.app.api.dtos.commons.MetaDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentRsDTO {
    private MetaDTO meta;
    private Data data;

    @lombok.Data
    @Builder
    public static class Data {
        private String idTournament;
        private String nameTournament;
    }
}
