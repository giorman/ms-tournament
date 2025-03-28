package co.com.esport.app.model.gestiontorneo.request;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TournamentRq {

    private String messageId;
    private String name;
    private String game;
    private String description;
    private String idOrganizer;
    private String streamingPlatform;
    private String status;
    private Date startDate;
    private Date endDate;
    private String category;
    private ArrayList<Prizes> prizes;
    private ArrayList<SalesStages> salesStages;



    @lombok.Data
    @AllArgsConstructor
    public static class Prizes {

        private String prize;

    }

    @lombok.Data
    @AllArgsConstructor
    @Builder
    public static class SalesStages {

        private String stageName;
        private Date startDate;
        private Date endDate;
        private String price;

    }
}
