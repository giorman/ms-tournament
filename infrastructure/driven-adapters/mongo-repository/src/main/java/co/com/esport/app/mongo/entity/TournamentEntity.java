package co.com.esport.app.mongo.entity;

import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;



@Document(collection = "tournament")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TournamentEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private String game;
    private String idOrganizer;
    private String streamingPlatform;
    private String status;
    private Date startDate;
    private Date endDate;
    private String category;
    private ArrayList<TournamentRq.Prizes> prizes;
    private ArrayList<TournamentRq.SalesStages> salesStages;
    private Integer numberPlayers;
    private ArrayList<TournamentRq.Cordinator> cordinator;
    private Boolean free;






}
