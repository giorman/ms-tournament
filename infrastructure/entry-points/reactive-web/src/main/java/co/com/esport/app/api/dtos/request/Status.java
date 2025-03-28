package co.com.esport.app.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Status {

    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private String status;
}
