package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.CreateCondominiumUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GetCondominiumUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.ListCondominiumsUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.UpdateCondominiumUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CondominiumService {

    private final CreateCondominiumUseCase createCondominiumUseCase;
    private final UpdateCondominiumUseCase updateCondominiumUseCase;
    private final ListCondominiumsUseCase listCondominiumsUseCase;
    private final GetCondominiumUseCase getCondominiumUseCase;

    public CondominiumService(CreateCondominiumUseCase create, UpdateCondominiumUseCase update, ListCondominiumsUseCase list, GetCondominiumUseCase get) {
        this.createCondominiumUseCase = create;
        this.updateCondominiumUseCase = update;
        this.listCondominiumsUseCase = list;
        this.getCondominiumUseCase = get;
    }

    public Condominium create(String name, String street, String city, String state, String zipcode, String country) throws InvalidFieldException, ConflictException {
        return createCondominiumUseCase.execute(name, street, city, state, zipcode, country);
    }

    public Condominium update(UUID id, String name, String street, String city, String state, String zipcode, String country) throws InvalidFieldException, ConflictException, NotFoundException {
        return updateCondominiumUseCase.execute(id, name, street, city, state, zipcode, country);
    }

    public List<Condominium> list() {
        return listCondominiumsUseCase.execute();
    }

    public Condominium get(UUID id) throws NotFoundException {
        return getCondominiumUseCase.execute(id);
    }
}
