package br.edu.infnet.vagnersiqueirajuniorapi.application.exception;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<BaseExceptionMessage> handleConflictException(ConflictException exception) {
        BaseExceptionMessage body = new BaseExceptionMessage(
                exception.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseExceptionMessage> handleGeneralException(Exception ex) {
        BaseExceptionMessage body = new BaseExceptionMessage(
                "Something went wrong. Go back later",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
