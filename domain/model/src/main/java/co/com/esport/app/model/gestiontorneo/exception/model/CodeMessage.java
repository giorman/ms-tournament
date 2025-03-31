package co.com.esport.app.model.gestiontorneo.exception.model;

public class CodeMessage {

    public static final String UNKNOWN_ERROR_DETAIL = "Ha ocurrido un error interno en el servicio";
    public static final String SUID_AVAILABILITY_DETAIL = "Ha ocurrido un error interno en el servicio";
    public static final String TRANSACTION_AVAILABILITY_DETAIL = "Ha ocurrido un error interno en el " +
            "servicio de transacciones";
    public static final String CATEGORY_NOT_FOUND = "La categoria no existe";
    public static final String STATUS_INVALID = "El estado no es valido";
    public static final String INVALID_MESSAGEID = "Faltan cabeceras obligatorias";
    public static final String BODY_DATA_REQUIRED = "Faltan datos obligatorios en el body";
    public static final String NOT_EXIST_PARAMETER_DETAIL = "No se encuentran resultados para el parámetro consultado";
    public static final String INVALID_STATUS_ROLE_DETAIL = "Estado de role incorrecto";
    public static final String INVALID_DATA_DETAIL = "Uno o más datos no poseen un valor válido";
    public static final String SUID_CONSUMER_DETAIL = "El consumidor no se encuentra registrado";
    public static final String ROLE_NOT_EXIST_DETAIL = "El rol no existe";
    public static final String EMPTY_RELATIONSHIP_DETAIL = "No se encuentran registros de relacionamiento.";
    public static final String NOT_PRIVILEGES_DETAIL = "No cuenta con los permisos para ejecutar la acción.";
    public static final String INVALID_ROLE_DETAIL = "Rol inválido.";
    public static final String PRIVILEGE_NOT_EXISTS_DETAIL = "Privilegio no existe";
    public static final String INVALID_PRIVILEGE_DETAIL = "Privilegio inválido.";
    public static final String FUNCTIONALITY_NOT_EXISTS_DETAIL = "Funcionalidad no existe";
    public static final String PRODUCT_GROUP_NOT_EXISTS_DETAIL = "Grupo de productos no existe.";
    public static final String ROLE_WITHOUT_FUNCTIONALITY_DETAIL = "No puede actualizar un rol sin funcionalidad";
    public static final String ROLE_EXISTS_DETAIL = "El Rol ya existe.";
    public static final String TRANSACTION_IN_PROCESS_DETAIL = "Ya existe una transacción en proceso";
    public static final String ROLE_HAS_RELATIONSHIPS_DETAIL = "No es posible actualizar el role";
    public static final String SUBMITTED_ROLE_EXISTS_WITH_THAT_STATUS_DETAIL = "Role existe con el estado enviado";
    public static final String UPDATE_IN_PROCESS_DETAIL = "Existe una actualización en proceso";
    public static final String FAILED_EVENT_TRANSACTION_DETAIL = "Ha ocurrido un error interno en el servicio";
    public static final String DO_NOT_FOUND_ROLE_INFORMATION_IN_CACHE = "No se han encontraron registros en cache";
    public static final String UNKNOWN_ERROR_IN_ROLE_CACHE_SERVICE =
            "Ha ocurrido un error interno en el servicio transversal de limpieza de cache para información de roles";


    private CodeMessage() {
        throw new IllegalStateException("CodeMessage class");
    }

}