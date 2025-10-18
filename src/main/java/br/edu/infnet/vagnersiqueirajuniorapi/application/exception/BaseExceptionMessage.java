package br.edu.infnet.vagnersiqueirajuniorapi.application.exception;

import java.time.LocalDateTime;

public record BaseExceptionMessage(String message, int code, LocalDateTime timestamp) {
}
