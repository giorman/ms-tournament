package co.com.esport.app.api.dtos.request;


import co.com.esport.app.model.gestiontorneo.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TournamentRqDto {

    private Data data;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @lombok.Data
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
        private Data.OrganizerDto organizer;
        private Status status;


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
