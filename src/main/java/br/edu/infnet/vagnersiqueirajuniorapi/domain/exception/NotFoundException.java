package br.edu.infnet.vagnersiqueirajuniorapi.domain.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
