package com.famisanarprueba.appbackfamisanar.exception;

import com.famisanarprueba.appbackfamisanar.dto.ExceptionDtoOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import utilities.Constants;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionDtoOut> manageUnexpectedException(Exception ex) {
    log.error("Exception: ", ex);
    ExceptionDtoOut exceptionDtoOut = ExceptionDtoOut.builder()
        .message("Error inesperado")
        .result(Constants.ERROR)
        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build();
    return new ResponseEntity<>(exceptionDtoOut, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ErrorGeneralException.class)
  public ResponseEntity<ExceptionDtoOut> manageErrorGeneralException(ErrorGeneralException ex) {
    log.error("ErrorGeneralException: ", ex);
    ExceptionDtoOut exceptionDtoOut = ExceptionDtoOut.builder()
        .message(ex.getMessage())
        .result(Constants.ERROR)
        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build();
    return new ResponseEntity<>(exceptionDtoOut, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionDtoOut> manageNotFoundException(NotFoundException ex) {
    log.error("NotFoundException: ", ex);
    ExceptionDtoOut exceptionDtoOut = ExceptionDtoOut.builder()
        .message(ex.getMessage())
        .result(Constants.ERROR)
        .code(HttpStatus.NOT_FOUND.value())
        .build();
    return new ResponseEntity<>(exceptionDtoOut, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionDtoOut> handleValidationErrors(MethodArgumentNotValidException ex) {
    log.error("MethodArgumentNotValidException: ", ex);
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error ->
        errors.put(error.getField(), error.getDefaultMessage())
    );

    ExceptionDtoOut exceptionDtoOut = ExceptionDtoOut.builder()
        .message("Error en campos de entrada")
        .result(Constants.ERROR)
        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .validations(errors)
        .build();

    return new ResponseEntity<>(exceptionDtoOut, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
