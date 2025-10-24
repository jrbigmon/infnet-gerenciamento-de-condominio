package br.edu.infnet.vagnersiqueirajuniorapi.application.mapper;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.GenerateApartmentResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;

import java.util.List;

public class ApartmentMapper {
    public static GenerateApartmentResponseDto map(Apartment apartment) {
        return new GenerateApartmentResponseDto(apartment.getIdentifier(), apartment.getFloor());
    }

    public static List<GenerateApartmentResponseDto> map(List<Apartment> apartments) {
        return apartments.stream().map(a -> new GenerateApartmentResponseDto(a.getIdentifier(), a.getFloor())).toList();
    }
}
