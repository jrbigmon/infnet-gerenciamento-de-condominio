package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.MAX_FLOORS;
import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.MIN_FLOORS;

public record UpdateApartmentDto(@NotNull() String identifier,
                                 @NotNull() @Min(MIN_FLOORS) @Max(MAX_FLOORS) Integer floor) {
}
