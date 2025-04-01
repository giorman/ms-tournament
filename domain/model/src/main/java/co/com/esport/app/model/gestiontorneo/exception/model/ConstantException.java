package co.com.esport.app.model.gestiontorneo.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ConstantException implements ErrorManagment {

    UNKNOWN_ERROR(
            CodeMessage.UNKNOWN_ERROR_DETAIL),
    MESSAGEID_ERROR(
            CodeMessage.INVALID_MESSAGEID),
    DATA_ERROR(
            CodeMessage.BODY_DATA_REQUIRED),
    STATUS_ERROR(
            CodeMessage.STATUS_INVALID),
    SALES_STAGES_NULL(
            CodeMessage.SALES_STAGES_INVALID),
    CREATE_ERROR(
            CodeMessage.CREATE_BD_ERROR),
    TOURNEY_LIMIT_EXCEEDED(
            CodeMessage.FREE_LIMIT_EXCEEDED),
    CORDINATOR_LIMIT_EXCEEDED(
            CodeMessage.COORDINATOR_LIMIT),
    PRIZES_LIMIT_EXCEEDED(
            CodeMessage.PRIZES_LIMIT),
    SALESSTAGES_LIMIT_EXCEEDED(
            CodeMessage.SALESSTAGES_LIMIT),
    PLATFORM_ERROR(
            CodeMessage.PLATFORM_INVALID),
    PLAYERS_LIMIT_EXCEEDED(
            CodeMessage.PLAYERS_LIMIT),
    TOURNAMENT_NOT_FOUND(
            CodeMessage.TOURNAMENT_NOT_FOUND),
    CATEGORY_INVALID(
            CodeMessage.CATEGORY_NOT_FOUND);

    private final String message;



}
