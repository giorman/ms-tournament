package co.com.esport.app.model.gestiontorneo.utils;

import java.util.regex.Pattern;

public final class Constants {

    public static final String APPLICATION_NAME = "ms_admin_authorization";
    public static final String EVENTS_DOCUMENTS_PATH = "deployment/ApiDoc/";

    private Constants() {
    }


    //NUMBERS
    public static final int ZERO = 0;
    public static final int ONE = 1;

    public static final String DATE_FORMAT = "dd/MM/yyyy hh:mm:ss:ms";
    public static final String NULL_VALUE = "NULL";
    public static final String EMPTY_VALUE = "";
    public static final String OPTIONAL = "OPTIONAL";
    public static final String CODE = "code";
    public static final String ENTITLEMENT = "ENTITLEMENT";
    public static final Pattern REGEX_AID_PATTERN = Pattern.compile("^A[A-Z0-9]{32}$");
    public static final Pattern REGEX_UUID_PATTERN = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-" +
            "[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    public static final Pattern NAME_ROLE_PATTERN = Pattern.compile("^[a-zA-Z0-9 ()./\\-,áéíóúÁÉÍÓÚñ_]{1,30}$");
    public static final Pattern ID_RELATION_PATTERN =
            Pattern.compile("^REL([A-Z0-9]{16}|[A-Z0-9]{30})$");
    public static final Pattern ID_ROLE_PATTERN = Pattern.compile("^ROL([A-Z0-9]{16}|[A-Z0-9]{30})$");
    public static final Pattern ID_FUNCTIONALITY_PATTERN = Pattern.compile("^FUNC([0-9]{16}|[0-9]{29})$");
    public static final Pattern ID_PRODUCT_GROUP_ID_PATTERN = Pattern.compile("^GPR([A-Z0-9]{16}|[A-Z0-9]{30})$");
    public static final Pattern ID_PRIVILEGE_PATTER = Pattern.compile("^PRIV00[1-5]$");

    //TRANSACTION RESULTS TITLE
    public static final String SUCCESS_TRANSACTION_TITLE = "Operación exitosa";
    public static final String FAILED_TRANSACTION_TITLE = "Operación fallida";
    public static final String CREATE = "CREATE";
    public static final String CREATE_ROLE = "CREAR ROL";
    public static final String UPDATE = "UPDATE";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String UPDATE_STATE = "MODIFICAR EL ESTADO DE UN ROL";
    public static final String UPDATE_ATTRIBUTES_ROLE = "MODIFICAR LOS ATRIBUTOS DE UN ROL";

    //MODEL STATUS TO SAVE
    public static final String STATUS_ACTIVE_SAVE = "STA01";
    public static final String STATUS_DELETED_DESCRIPTION = "Eliminado";
    public static final String STATUS_ACTIVE_DESCRIPTION = "Activo";
    public static final String STATUS_PENDING_DESCRIPTION = "Pendiente";
    public static final String STATUS_DELETE_SAVE = "STA03";
    public static final String STATUS_INACTIVE = "STA02";

    //HEADERS NAMES
    public static final String MESSAGE_ID_HEADER = "message-id";
    public static final String CONSUMER_ACRONYM_HEADER = "Consumer-Acronym";
    public static final String CONSUMER_ACRONYM_V2 = "consumer-acronym";
    public static final String CONSUMER_AID_CREATOR_HEADER = "AID_CREATOR";
    public static final String AID_CREATOR_V2 = "aid-creator";
    public static final String RELATION_IDENTIFIER = "relations-identifier";

    //COMMONS VALIDATIONS
    public static final String ID_ROLE_STARTING = "ROL";
    public static final int ID_ROLE_LENGTH = 16;
    public static final String FUNCTIONALITY_STARTING = "FUNC";
    public static final int FUNCTIONALITY_LENGTH = 20;
    public static final int REFERENCE_MAX_LENGTH = 100;

    //DELEGATE VS CHANNEL
    public static final String CHANNEL_EXPIRATION_DAYS = "channel_expiration_day";
    public static final String CHANNEL_DELEGATES_NUMBER = "channel_delegates_number";
    public static final String CHANNEL_EXPIRATION_DAYS_DESCRIPTION = "Días de expiración del canal";
    public static final String CHANNEL_DELEGATES_NUMBER_DESCRIPTION = "Número de delegados del canal";

    //DATA PRIVILEGES
    public static final String PRIVILEGE_FREELANCE_ADMINISTRATOR_ID = "PRIV001";
    public static final String PRIVILEGE_PREPARED_APPROVING_ID = "PRIV002";
    public static final String PRIVILEGE_PREPARED_ID = "PRIV004";

    //DATA FUNCTIONALITIES
    public static final String MANAGEMENT_ENTITLEMENT = "Gestion Entitlement";
    public static final String MANAGEMENT_SECURITY = "Gestion Seguridad";
    public static final String MANAGEMENT_FLOW = "Gestion Flujos";
    public static final String FIRST_FUNCTIONALITY_ENTITLEMENT = "FUNC0000000000000000";
    public static final String FIRST_FUNCTIONALITY_SECURITY = "FUNC0000000000000100";
    public static final String FIRST_FUNCTIONALITY_FLOW = "FUNC0000000000000200";
    public static final String FUNC_ADMINISTRATIVE = "ADMINISTRATIVA";
    public static final String ID_FUNC_ADMINISTRATIVE = "FUNG000000000000003";
    public static final String FUNC_MONETARY = "MONETARIA";
    public static final String DESCRIPTION_FUNCTIONALITY = "Funcionalidad otorgada por el canal o grupo";

    //DATA TITULAR ROLES NAMES
    public static final String TITULAR = "TITULAR";
    public static final String REPLEGAL = "REPLEGAL";
    public static final String TITULAR_REPLEGAL = "TITULAR REPLEGAL";
    public static final String TITULAR_MONETARY = "TITULAR MONETARIO";
    public static final String TITULAR_ADMINISTRATIVE = "TITULAR ADMINISTRATIVO";
    public static final String TITULAR_REPLEGAL_MONETARY = "TITULAR MONETARIO REPLEGAL";
    public static final String TITULAR_ADMINISTRATIVE_REPLEGAL = "TITULAR ADMINISTRATIVO REPLEGAL";

    //DATA ACRONYM ROLES
    public static final String TIT = "TIT";
    public static final String TMR = "TMR";
    public static final String TAR = "TAR";
    public static final String TMO = "TMO";
    public static final String TAD = "TAD";
    public static final String REP = "REP";
    public static final String TRE = "TRE";
    //DATA PRODUCTS
    public static final String ID_PRODUCT_GROUP_ALL = "GPR0000000000000000";

    //DATA SECURITY CONTROL
    public static final String AUTONOMOUS_ADMINISTRATION = "ESQ0001";
    public static final String SHARED_ADMINISTRATION = "ESQ0002";
    public static final String SHARED_ADMINISTRATION_CATEGORY = "ESQ0003";

    //TRANSACTION RESULT STATUS
    public static final String SUCCESS_TRANSACTION_200 = "200";
    public static final String SUCCESS_TRANSACTION_201 = "201";
    public static final String SUCCESS_TRANSACTION_202 = "202";
    public static final String STATUS_200_OK = "200-Exitoso";
    public static final String STATUS_201_OK = "201-EXITOSO";
    public static final String APPROVED_RESULT = "APROBADA";
    public static final String STATUS_202_OK = "202-EXITOSO";
    public static final String PREPARED_RESULT = "PREPARADA";
    public static final String FINISH_TRANSACTION = "FINALIZADA";
    public static final String RESULT_CREATE_DESCRIPTION = "El registro se ha creado correctamente";
    public static final String CHANGE_ROLE_STATE_200 = "Cambio de estado de role exitosamente";
    public static final String CHANGE_ROLE_STATE_202 = "Cambio de estado de role exitosamente y " +
            "pendiende de aprobación";
    public static final String UPDATE_ROLE_200 = "Role actualizado exitosamente";
    public static final String UPDATE_ROLE_DESCRIPTION_200 = "Role actualizado exitosamente y pendiende de aprobación";

    //TRANSACTION RESULTS TYPE
    public static final String SUCCESS_TRANSACTION_TYPE = "SUCCESS";
    public static final String UPDATE_ATTRIBUTE_ROLE_PENDING =
            "Actualización exitosa y pendiente de aprobación";
    public static final String UPDATE_ATTRIBUTE_ROLE =
            "Role actualizado exitosamente";
    public static final String GET_PARAM_SUCCESS =
            "La consulta de parámetros ha sido exitosa";
    public static final String CREATE_SUCCESS_DETAIL_PENDING =
            "Creacion Exitosa y pendiente de aprobacion";
    public static final String CREATE_ROLE_SUCCESS_DETAIL =
            "Rol creado correctamente";

    //TRANSACTION STATUS
    public static final int PREPARE_TRANSACTION_ID_STATUS = 1;
    public static final int APPROVE_TRANSACTION_ID_STATUS = 4;

    //EVENTS NAMES
    public static final String EVENT = "EVENT";
    public static final String CREATE_ROLE_EVENT_NAME = "entitlement.authorization.role.created";
    public static final String UPDATE_ROLE_EVENT_NAME = "entitlement.authorization.role.updated";
    public static final String UPDATE_ROLE_STATUS_EVENT_NAME = "entitlement.authorization.role.status_updated";


    //EVENT ROUTING KEYS
    public static final String UPDATE_ROLE_STATUS_ROUTING_KEY = "entitlement.role.status.updated";
    public static final String UPDATE_ROLE_ATTRIBUTES_ROUTING_KEY = "entitlement.role.updated";

    //QUERY TRANSLATE
    public static final String TRANSLATE_FROM_CHARACTERS = "áéíóúÁÉÍÓÚ";
    public static final String TRANSLATE_TO_CHARACTERS = "aeiouAEIOU";
}
