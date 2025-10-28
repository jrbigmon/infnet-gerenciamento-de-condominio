package br.edu.infnet.vagnersiqueirajuniorapi.application.exception;

import java.time.LocalDateTime;

public record BaseExceptionMessage(Object message, Object errors, int code, LocalDateTime timestamp) {
}
