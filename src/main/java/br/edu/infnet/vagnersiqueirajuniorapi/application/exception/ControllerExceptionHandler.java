package br.edu.infnet.vagnersiqueirajuniorapi.application.exception;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<BaseExceptionMessage> handleConflictException(ConflictException exception) {
        BaseExceptionMessage body = new BaseExceptionMessage(
                List.of(exception.getMessage()), null, HttpStatus.CONFLICT.value(), LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<BaseExceptionMessage> handleInvalidFieldException(InvalidFieldException exception) {
        BaseExceptionMessage body = new BaseExceptionMessage(
                exception.getMessage(), exception.getErrors(),
                                                             HttpStatus.BAD_REQUEST.value(), LocalDateTime.now()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseExceptionMessage> handleNotFoundException(NotFoundException exception) {
        BaseExceptionMessage body = new BaseExceptionMessage(
                List.of(exception.getMessage()), null, HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseExceptionMessage> handleGeneralException(Exception ex) {
        BaseExceptionMessage body = new BaseExceptionMessage(
                "Something went wrong. Go back later", null,
                                                             HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                             LocalDateTime.now()
        );
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseExceptionMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

        BaseExceptionMessage body = new BaseExceptionMessage(
                "invalid fields", errors, HttpStatus.BAD_REQUEST.value(),
                                                             LocalDateTime.now()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
