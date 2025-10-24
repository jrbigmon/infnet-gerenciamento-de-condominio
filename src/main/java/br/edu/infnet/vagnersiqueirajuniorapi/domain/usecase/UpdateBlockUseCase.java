package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;

import java.util.UUID;

public record UpdateBlockUseCase(IBlockRepository blockRepository) {
    public Block execute(Condominium condominium, UUID blockId, String identifier, Integer floors) throws
                                                                                                   NotFoundException,
                                                                                                   InvalidFieldException,
                                                                                                   ConflictException {

        Block block = blockRepository.findByIdAndCondominiumId(blockId, condominium);

        if (block == null) {
            throw new NotFoundException("Block not found");
        }

        block.update(identifier, floors);

        condominium.addBlock(block, this::checkDuplicate);

        blockRepository.save(block);

        return block;
    }

    private boolean checkDuplicate(Block block, Condominium condominium) {
        return this.blockRepository.existsWithinCondominiumWithSameIdentifier(block, condominium);
    }
}
