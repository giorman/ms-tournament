package co.com.esport.app.api.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    ACCION("Acción"),
    AVENTURA("Aventura"),
    ROL("Rol"),
    ESTRATEGIA("Estrategia"),
    SIMULACION("Simulación"),
    DEPORTES("Deportes"),
    PUZLE("Rompecabezas"),
    MUSICA("Música"),
    LUCHA("Lucha"),
    CARRERAS("Carreras"),
    MOBA("MOBA");

    private final String category;



    // Puedes agregar más métodos si es necesario, como:

//    public static TipoJuego fromString(String nombre) {
//        for (TipoJuego tipo : TipoJuego.values()) {
//            if (tipo.nombre.equalsIgnoreCase(nombre)) {
//                return tipo;
//            }
//        }
//        throw new IllegalArgumentException("No se encontró el tipo de juego: " + nombre);
//    }
}
