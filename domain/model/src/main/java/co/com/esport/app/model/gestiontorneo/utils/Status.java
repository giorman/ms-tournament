package co.com.esport.app.model.gestiontorneo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Status {

    ACTIVE("active"),
    INACTIVE("inactive"),
    DELETED("deleted"),;

    private String status;

    public static boolean isValidStatus(String status) {
        for (Status s : Status.values()) {
            if (s.getStatus().equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }
}
