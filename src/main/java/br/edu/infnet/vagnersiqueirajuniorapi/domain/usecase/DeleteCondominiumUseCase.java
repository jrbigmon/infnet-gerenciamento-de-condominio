package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

public record DeleteCondominiumUseCase(ICondominiumRepository condominiumRepository, IBlockRepository blockRepository,
                                       IApartmentRepository apartmentRepository) {
    public void execute(Condominium condominium) {
        apartmentRepository.deleteAllByCondominium(condominium);
        blockRepository.deleteAllByCondominium(condominium);
        condominiumRepository.delete(condominium);
    }
}
