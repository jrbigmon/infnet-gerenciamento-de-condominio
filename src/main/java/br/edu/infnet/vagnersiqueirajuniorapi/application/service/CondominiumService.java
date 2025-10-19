package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.CreateCondominiumUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.UpdateCondominiumUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CondominiumService {

    private final CreateCondominiumUseCase createCondominiumUseCase;
    private final UpdateCondominiumUseCase updateCondominiumUseCase;


    public CondominiumService(CreateCondominiumUseCase createCondominiumUseCase, UpdateCondominiumUseCase updateCondominiumUseCase) {
        this.createCondominiumUseCase = createCondominiumUseCase;
        this.updateCondominiumUseCase = updateCondominiumUseCase;
    }

    public Condominium create(String name, String street, String city, String state, String zipcode, String country) throws InvalidFieldException, ConflictException {
        return createCondominiumUseCase.execute(name, street, city, state, zipcode, country);
    }

    public Condominium update(UUID id, String name, String street, String city, String state, String zipcode, String country) throws InvalidFieldException, ConflictException, NotFoundException {
        return updateCondominiumUseCase.execute(id, name, street, city, state, zipcode, country);
    }
}
