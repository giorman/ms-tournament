package co.com.esport.app.model.gestiontorneo.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor //
@NoArgsConstructor
@Builder(toBuilder = true) //Construye
public class CreateTournamentRs {
    private String idTournament;
    private String nameTournament;

}
