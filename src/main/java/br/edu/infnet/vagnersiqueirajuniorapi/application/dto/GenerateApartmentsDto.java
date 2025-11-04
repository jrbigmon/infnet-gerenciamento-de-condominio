package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.*;

public record GenerateApartmentsDto(@NotNull @Min(MIN_FLOORS) @Max(MAX_FLOORS) Integer floorStart,
                                    @NotNull @Min(MIN_FLOORS) @Max(MAX_FLOORS) Integer floorEnd,
                                    @NotNull @Min(MIN_APARTMENTS_PER_FLOOR) @Max(MAX_APARTMENTS_PER_FLOOR) Integer apartmentQuantity) {
}
