package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CondominiumService {

    private final CreateCondominiumUseCase createCondominiumUseCase;
    private final UpdateCondominiumUseCase updateCondominiumUseCase;
    private final ListCondominiumsUseCase listCondominiumsUseCase;
    private final GetCondominiumUseCase getCondominiumUseCase;
    private final DeleteCondominiumUseCase deleteCondominiumUseCase;

    public CondominiumService(CreateCondominiumUseCase createCondominiumUseCase,
                              UpdateCondominiumUseCase updateCondominiumUseCase,
                              ListCondominiumsUseCase listCondominiumsUseCase,
                              GetCondominiumUseCase getCondominiumUseCase,
                              DeleteCondominiumUseCase deleteCondominiumUseCase) {
        this.createCondominiumUseCase = createCondominiumUseCase;
        this.updateCondominiumUseCase = updateCondominiumUseCase;
        this.listCondominiumsUseCase = listCondominiumsUseCase;
        this.getCondominiumUseCase = getCondominiumUseCase;
        this.deleteCondominiumUseCase = deleteCondominiumUseCase;
    }

    public Condominium create(String name, String street, String city, String state, String zipcode,
                              String country) throws InvalidFieldException, ConflictException {
        return createCondominiumUseCase.execute(name, street, city, state, zipcode, country);
    }

    public Condominium update(UUID id, String name, String street, String city, String state, String zipcode,
                              String country) throws InvalidFieldException, ConflictException, NotFoundException {
        return updateCondominiumUseCase.execute(id, name, street, city, state, zipcode, country);
    }

    public List<Condominium> list() {
        return listCondominiumsUseCase.execute();
    }

    public Condominium get(UUID id) throws NotFoundException {
        return getCondominiumUseCase.execute(id);
    }

    public void delete(UUID id) throws NotFoundException {
        Condominium condominium = getCondominiumUseCase.execute(id);
        deleteCondominiumUseCase.execute(condominium);
    }
}
