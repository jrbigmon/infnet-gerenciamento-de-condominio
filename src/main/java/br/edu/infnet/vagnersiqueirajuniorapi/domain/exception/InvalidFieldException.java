package br.edu.infnet.vagnersiqueirajuniorapi.domain.exception;

public class InvalidFieldException extends IllegalArgumentException {
    public InvalidFieldException(String message) {
        super(message);
    }
}
