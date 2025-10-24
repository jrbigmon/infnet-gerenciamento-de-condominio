package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;

import java.util.UUID;

public record GetBlockUseCase(IBlockRepository blockRepository) {
    public Block execute(Condominium condominium, UUID blockId) throws NotFoundException {
        Block block = blockRepository.findByIdAndCondominiumId(blockId, condominium);

        if (block == null) {
            throw new NotFoundException("Block not found");
        }

        return block;
    }
}
