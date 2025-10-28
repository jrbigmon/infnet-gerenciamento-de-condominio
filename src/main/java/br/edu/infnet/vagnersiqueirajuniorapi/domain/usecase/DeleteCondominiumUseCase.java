package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

public record DeleteCondominiumUseCase(ICondominiumRepository condominiumRepository, IBlockRepository blockRepository) {
    public void execute(Condominium condominium) {
        blockRepository.deleteAllByCondominium(condominium);
        condominiumRepository.delete(condominium);
    }
}
