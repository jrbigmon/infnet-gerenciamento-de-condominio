package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;

public record UpdateApartmentUseCase(IApartmentRepository apartmentRepository) {
    public Apartment execute(Block block, Apartment apartment, String identifier, Integer floor) {
        apartment.update(identifier, floor);

        block.addApartment(apartment, this::checkDuplicate);

        apartmentRepository.save(apartment);

        return apartment;
    }

    private boolean checkDuplicate(Apartment apartment, Block block) {
        return this.apartmentRepository.existsWithinBlockWithSameIdentifier(apartment, block);
    }
}
