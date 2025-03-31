package co.com.esport.app.api.dtos.request;


import co.com.esport.app.model.gestiontorneo.utils.Status;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentRqDto {

    private Data data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @lombok.Data
    @Builder
    public static class Data {

        private String tournamentName;
        private String description;
        private String game;
        private String category;
        private String streamingPlatform;
        private ArrayList<Prizes> prizes;
        private ArrayList<SalesStages> salesStages;
        private Date startDate;
        private Date endDate;
        private OrganizerDto organizer;
        private Status status;
        private Number numberPlayers;
        private ArrayList<Cordinator> cordinator;
        private Boolean free;


        @lombok.Data
        public static class Cordinator {

            private String id;

        }

        @lombok.Data
        public static class OrganizerDto {

            private String id;

        }


        @lombok.Data
        public static class Prizes {

            private String prize;

        }

        @lombok.Data
        public static class SalesStages {

            private String stageName;
            private Date startDate;
            private Date endDate;
            private String price;

        }





    }
}
