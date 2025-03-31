package co.com.esport.app.model.gestiontorneo.request;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Category {

    private String id;
    private String name;
    private String description;
    private Capacity capacity;

    @Data
    public static class Capacity{
        private int visualizers;
        private int players;

    }




}
