package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;

public record DeleteBlockUseCase(IBlockRepository blockRepository) {
    public void execute(Block block) {
        blockRepository.delete(block);
    }
}
