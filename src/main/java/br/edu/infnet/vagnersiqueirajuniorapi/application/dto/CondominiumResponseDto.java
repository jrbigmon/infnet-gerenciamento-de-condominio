package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

import java.util.UUID;

public record CondominiumResponseDto(UUID id, String name, AddressResponseDto address) {
}
