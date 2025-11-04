package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

import java.util.UUID;

public record ApartmentResponseDto(UUID id, String identifier, Integer floor) {
}
