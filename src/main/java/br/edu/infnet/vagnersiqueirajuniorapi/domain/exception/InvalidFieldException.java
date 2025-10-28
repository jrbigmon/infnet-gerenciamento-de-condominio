package br.edu.infnet.vagnersiqueirajuniorapi.domain.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class InvalidFieldException extends IllegalArgumentException {
    private final Map<String, String> errors = new HashMap<>();

    public InvalidFieldException(String message) {
        super(message);
    }

    public void putError(String field, String message) {
        errors.put(field, message);
    }

    public boolean isNotEmpty() {
        return !errors.isEmpty();
    }
}
