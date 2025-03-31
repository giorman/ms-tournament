package co.com.esport.app.model.gestiontorneo.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Platform {

        TWITCH("twitch"),
        YOUTUBE_GAMING("youTube gaming"),
        KICK("kick"),
        FACEBOOK_GAMING("facebook gaming"),
        TROVO("trovo");

        private final String platform;


        public static boolean isValidPlatform(String platform) {
                for (Platform p : Platform.values()) {
                        if (p.getPlatform().equalsIgnoreCase(platform)) {
                                return true;
                        }
                }
                return false;
        }

}
