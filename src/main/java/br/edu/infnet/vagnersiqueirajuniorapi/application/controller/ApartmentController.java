package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CreateApartmentsDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.GenerateApartmentResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.mapper.ApartmentMapper;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.ApartmentService;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("condominiums/{id}/blocks/{blockId}/apartments/generate")
    public List<GenerateApartmentResponseDto> create(@PathVariable UUID id, @PathVariable UUID blockId,
                                                     @RequestBody CreateApartmentsDto input) {
        List<Apartment> apartments = apartmentService.generate(
                id, blockId, input.floorStart(), input.floorEnd(), input.apartmentQuantity());
        return ApartmentMapper.map(apartments);
    }
}
