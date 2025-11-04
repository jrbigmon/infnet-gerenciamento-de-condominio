package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;

public record DeleteBlockUseCase(IBlockRepository blockRepository, IApartmentRepository apartmentRepository) {
    public void execute(Block block) {
        apartmentRepository.deleteAllByBlock(block);
        blockRepository.delete(block);
    }
}
