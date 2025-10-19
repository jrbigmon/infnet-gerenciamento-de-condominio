package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.Address;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

import java.util.UUID;

public record UpdateCondominiumUseCase(ICondominiumRepository condominiumRepository) {
    public Condominium execute(UUID id, String name, String street, String city, String state, String zipcode, String country) throws InvalidFieldException, ConflictException, NotFoundException {
        Condominium condominium = condominiumRepository.findById(id);

        if (condominium == null) {
            throw new NotFoundException("Condominium not found");
        }

        condominium.setName(name);
        condominium.setAddress(new Address(street, city, state, zipcode, country));
        condominium.isValid();

        boolean exists = condominiumRepository.existsWithTheSameNameAndAddress(condominium);

        if (exists) {
            throw new ConflictException("Condominium already exists");
        }

        condominiumRepository.save(condominium);

        return condominium;
    }
}
