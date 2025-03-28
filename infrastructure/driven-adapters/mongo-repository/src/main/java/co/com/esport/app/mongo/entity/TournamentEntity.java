package co.com.esport.app.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;



@Document(collection = "torneos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TournamentEntity {

    @Id
    private String id;
    private String messageId;
    private String name;
    private String description;
    private String game;
    private String idOrganizer;
    private String status;
    private Date startDate;
    private String idCategory;

}
