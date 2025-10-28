package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

import java.util.UUID;

public record GetCondominiumUseCase(ICondominiumRepository condominiumRepository) {
    public Condominium execute(UUID id) throws NotFoundException {
        Condominium condominium = condominiumRepository.findById(id);

        if (condominium == null) {
            throw new NotFoundException("Condominium not found");
        }

        return condominium;
    }
}
