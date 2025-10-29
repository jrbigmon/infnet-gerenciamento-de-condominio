package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.*;
import br.edu.infnet.vagnersiqueirajuniorapi.application.mapper.ApartmentMapper;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.ApartmentService;
import br.edu.infnet.vagnersiqueirajuniorapi.application.types.CreateApartmentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;

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

        return ApartmentMapper.apartmentToGenerateResponse(
                apartmentService.generate(
                        id, blockId, input.floorStart(), input.floorEnd(),
                        input.apartmentQuantity()
                ));
    }

    @PostMapping("condominiums/{id}/blocks/{blockId}/apartments/list")
    public void createList(@PathVariable UUID id, @PathVariable UUID blockId,
                           @RequestBody @Valid @Size(min = MIN_APARTMENTS, max = MAX_APARTMENTS) List<CreateApartmentDto> input) {
        apartmentService.createList(
                id, blockId,
                input.stream().map(a -> new CreateApartmentType(a.identifier(), a.floor())).toList()
        );
    }

    @GetMapping("condominiums/{id}/blocks/{blockId}/apartments")
    public List<ApartmentResponseDto> list(@PathVariable UUID id, @PathVariable UUID blockId) {
        return ApartmentMapper.apartmentToResponse(apartmentService.list(id, blockId));
    }

    @PutMapping("condominiums/{id}/blocks/{blockId}/apartments/{apartmentId}")
    public ApartmentResponseDto update(@PathVariable UUID id, @PathVariable UUID blockId,
                                       @PathVariable UUID apartmentId, @RequestBody UpdateApartmentDto input) {
        return ApartmentMapper.apartmentToResponse(
                apartmentService.update(id, blockId, apartmentId, input.identifier(), input.floor()));
    }

    @GetMapping("condominiums/{id}/blocks/{blockId}/apartments/{apartmentId}")
    public ApartmentResponseDto get(@PathVariable UUID id, @PathVariable UUID blockId, @PathVariable UUID apartmentId) {
        return ApartmentMapper.apartmentToResponse(apartmentService.get(id, blockId, apartmentId));
    }

    @DeleteMapping("condominiums/{id}/blocks/{blockId}/apartments/{apartmentId}")
    public void delete(@PathVariable UUID id, @PathVariable UUID blockId, @PathVariable UUID apartmentId) {
        apartmentService.delete(id, blockId, apartmentId);
    }
}
