package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record GenerateApartmentsDto(@NotNull() @Min(0) @Max(100) Integer floorStart,
                                    @NotNull() @Min(0) @Max(100) Integer floorEnd,
                                    @NotNull() @Min(1) @Max(40) Integer apartmentQuantity) {
}
