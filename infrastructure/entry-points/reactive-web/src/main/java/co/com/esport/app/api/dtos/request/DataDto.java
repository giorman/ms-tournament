package co.com.esport.app.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

    private String name;
    private String description;
    private String game;
    private OrganizerDto organizer;
    private CategoryDto category;
    private Date eventDate;
    private StatusDto status;
}
