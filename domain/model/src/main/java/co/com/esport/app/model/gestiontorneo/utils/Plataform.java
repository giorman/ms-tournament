package co.com.esport.app.model.gestiontorneo.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Plataform {

        TWITCH("Twitch"),
        YOUTUBE_GAMING("YouTube Gaming"),
        KICK("Kick"),
        FACEBOOK_GAMING("Facebook Gaming"),
        TROVO("Trovo"),
        RUMBLE_GAMING("Rumble Gaming"); //Incluyo rumble
        // Puedo incluir otra plataforma de streaming que no es de juegos en si como Discord Stage, es como un tipo de micro stream de juegos

        private final String platform;


//        public static Plataform fromString(String nombre) {
//            for (Plataform plataforma : Plataform.values()) {
//                if (plataforma.nombre.equalsIgnoreCase(nombre)) {
//                    return plataforma;
//                }
//            }
//            throw new IllegalArgumentException("No se encontró la plataforma de streaming de juegos: " + nombre);
//        }

}
