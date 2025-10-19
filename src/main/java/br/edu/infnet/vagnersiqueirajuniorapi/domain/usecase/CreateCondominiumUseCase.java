package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.Address;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

public record CreateCondominiumUseCase(ICondominiumRepository condominiumRepository) {

    public Condominium execute(String name, String street, String city, String state, String zipcode, String country) throws InvalidFieldException, ConflictException {
        Condominium condominium = Condominium.create(name, new Address(street, city, state, zipcode, country));

        boolean exists = condominiumRepository.existsWithTheSameNameAndAddress(condominium);

        if (exists) {
            throw new ConflictException("Condominium already exists");
        }

        condominiumRepository.save(condominium);

        return condominium;
    }
}
