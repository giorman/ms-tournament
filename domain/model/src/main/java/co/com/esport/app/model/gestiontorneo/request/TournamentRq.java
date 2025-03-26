package co.com.esport.app.model.gestiontorneo.request;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TournamentRq {

    private String messageId;
    private String name;
    private String description;
    private String game;
    private String idOrganizer;
    private String status;
    private Date startDate;
    private String idCategory;
}
