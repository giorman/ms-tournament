package co.com.esport.app.model.gestiontorneo.request;
import jdk.jshell.Snippet;
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

    private String id;
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
    private Integer numberPlayers;
    private ArrayList<Cordinator> cordinator;
    private Boolean free;


    @lombok.Data
    @AllArgsConstructor
    @Builder
    public static class Cordinator {

        private String id;
    }


    @lombok.Data
    @AllArgsConstructor
    @Builder
    public static class Prizes {

        private int position;
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
