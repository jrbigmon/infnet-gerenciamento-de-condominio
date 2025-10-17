package br.edu.infnet.vagnersiqueirajuniorapi.domain.exception;

public class ConflictException extends IllegalArgumentException {
    public ConflictException(String message) {
        super(message);
    }
}
