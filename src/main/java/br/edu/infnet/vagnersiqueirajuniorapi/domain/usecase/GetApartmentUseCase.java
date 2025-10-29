package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;

import java.util.UUID;

public record GetApartmentUseCase(IApartmentRepository apartmentRepository) {
    public Apartment execute(Block block, UUID apartmentId) {
        Apartment apartment = apartmentRepository.findByIdAndBlockId(apartmentId, block);

        if (apartment == null) {
            throw new NotFoundException("Apartment not found");
        }

        return apartment;
    }
}
