package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CreateApartmentDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.GenerateApartmentResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.GenerateApartmentsDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.mapper.ApartmentMapper;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.ApartmentService;
import br.edu.infnet.vagnersiqueirajuniorapi.application.types.CreateApartmentType;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.MAX_APARTMENTS;
import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.MIN_APARTMENTS;

@RestController
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("condominiums/{id}/blocks/{blockId}/apartments/generate")
    public List<GenerateApartmentResponseDto> generate(@PathVariable UUID id, @PathVariable UUID blockId,
                                                       @RequestBody @Valid GenerateApartmentsDto input) {
        List<Apartment> apartments = apartmentService.generate(
                id, blockId, input.floorStart(), input.floorEnd(), input.apartmentQuantity());
        return ApartmentMapper.map(apartments);
    }

    @PostMapping("condominiums/{id}/blocks/{blockId}/apartments/list")
    public void createList(@PathVariable UUID id, @PathVariable UUID blockId,
                           @RequestBody @Valid @Size(min = MIN_APARTMENTS, max = MAX_APARTMENTS) List<CreateApartmentDto> input) {
        apartmentService.createList(
                id, blockId,
                input.stream().map(a -> new CreateApartmentType(a.identifier(), a.floor())).toList()
        );
    }
}
