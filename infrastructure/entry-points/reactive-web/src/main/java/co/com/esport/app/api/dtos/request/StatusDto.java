package co.com.esport.app.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusDto {

    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private String status;
}
