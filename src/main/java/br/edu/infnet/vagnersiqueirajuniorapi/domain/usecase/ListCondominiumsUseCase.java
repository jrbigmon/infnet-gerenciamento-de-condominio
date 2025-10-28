package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

import java.util.List;

public record ListCondominiumsUseCase(ICondominiumRepository condominiumRepository) {

    public List<Condominium> execute() {
        return condominiumRepository.findAll();
    }

}
