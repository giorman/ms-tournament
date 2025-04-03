package co.com.esport.app.model.gestiontorneo.exception.model;

public class CodeMessage {

    public static final String UNKNOWN_ERROR_DETAIL = "Ha ocurrido un error interno en el servicio";
    public static final String CREATE_BD_ERROR = "Ha ocurrido un error interno bd creando el registro";
    public static final String UPDATE_BD_ERROR = "Ha ocurrido un error interno bd actualizando el registro";
    public static final String SALES_STAGES_INVALID = "Las etapas de ventas son requeridas";
    public static final String CATEGORY_NOT_FOUND = "La categoria no existe";
    public static final String STATUS_INVALID = "El estado no es valido";
    public static final String INVALID_MESSAGEID = "Faltan cabeceras obligatorias";
    public static final String BODY_DATA_REQUIRED = "Faltan datos obligatorios en el body";
    public static final String FREE_LIMIT_EXCEEDED = "Limite de torneos gratis alcanzado";
    public static final String COORDINATOR_LIMIT = "El limite maximo de coordinadores alcanzado";
    public static final String PRIZES_LIMIT = "El limite maximo de premios alcanzado";
    public static final String SALESSTAGES_LIMIT = "El limite maximo de etapas alcanzado";
    public static final String PLAYERS_LIMIT = "El limite maximo de jugadores alcanzado";
    public static final String PLATFORM_INVALID = "La plataforma no es valida";
    public static final String TOURNAMENT_NOT_FOUND = "El torneo no existe";


    private CodeMessage() {
        throw new IllegalStateException("CodeMessage class");
    }

}