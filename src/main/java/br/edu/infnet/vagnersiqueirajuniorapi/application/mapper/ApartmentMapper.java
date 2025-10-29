package br.edu.infnet.vagnersiqueirajuniorapi.application.mapper;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.ApartmentResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.GenerateApartmentResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;

import java.util.List;

public class ApartmentMapper {
    public static List<GenerateApartmentResponseDto> apartmentToGenerateResponse(List<Apartment> apartments) {
        return apartments.stream().map(a -> new GenerateApartmentResponseDto(a.getIdentifier(), a.getFloor())).toList();
    }

    public static List<ApartmentResponseDto> apartmentToResponse(List<Apartment> apartments) {
        return apartments.stream()
                         .map(a -> new ApartmentResponseDto(a.getId(), a.getIdentifier(), a.getFloor()))
                         .toList();
    }
}
