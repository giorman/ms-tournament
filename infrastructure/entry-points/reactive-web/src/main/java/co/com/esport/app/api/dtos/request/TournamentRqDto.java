package co.com.esport.app.api.dtos.request;

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

        private String id;
        private String tournamentName;
        private String description;
        private String game;
        private String category;
        private String streamingPlatform;
        private ArrayList<Prizes> prizes;
        private ArrayList<SalesStages> salesStages;
        private Date startDate;
        private Date endDate;
        private Organizer organizer;
        private String status;
        private Integer numberPlayers;
        private ArrayList<Cordinator> cordinator;
        private Boolean free;


        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Cordinator {

            private String id;

        }

        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Organizer {

            private String id;

        }


        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class Prizes {
            private int position;
            private String prize;

        }

        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class SalesStages {

            private String stageName;
            private Date startDate;
            private Date endDate;
            private String price;

        }





    }
}
