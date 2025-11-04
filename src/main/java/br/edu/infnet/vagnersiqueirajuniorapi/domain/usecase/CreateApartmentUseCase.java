package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;

public record CreateApartmentUseCase(IApartmentRepository apartmentRepository) {
    public Apartment execute(Block block, String identifier, Integer floor) throws ConflictException,
                                                                                   InvalidFieldException {
        Apartment apartment = block.createApartment(identifier, floor);

        block.addApartment(apartment, this::checkDuplicate);

        apartmentRepository.save(apartment);

        return apartment;
    }

    private boolean checkDuplicate(Apartment apartment, Block block) {
        return this.apartmentRepository.existsWithinBlockWithSameIdentifier(apartment, block);
    }
}
