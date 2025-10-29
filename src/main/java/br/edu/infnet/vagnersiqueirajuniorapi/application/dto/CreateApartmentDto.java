package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateApartmentDto(@NotNull() String identifier, @NotNull() @Min(0) Integer floor) {
}
