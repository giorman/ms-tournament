package co.com.esport.app.model.gestiontorneo.utils;

import java.util.regex.Pattern;

public final class Constants {


    private Constants() {
    }


    //NUMBERS

    public static final Pattern REGEX_UUID_PATTERN = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-" +
            "[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");



    //HEADERS NAMES
    public static final String MESSAGE_ID_HEADER = "message-id";

}
