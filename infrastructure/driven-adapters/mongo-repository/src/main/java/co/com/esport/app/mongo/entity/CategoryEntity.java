package co.com.esport.app.mongo.entity;

import co.com.esport.app.model.gestiontorneo.request.TournamentRq;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;


@Document(collection = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Capacity capacity;

    @Data
    @Getter
    private static class Capacity{
        private int visualizers;
        private int players;
    }




}
