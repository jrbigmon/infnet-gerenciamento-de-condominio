package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;

public record UpdateBlockUseCase(IBlockRepository blockRepository) {
    public Block execute(Condominium condominium, Block block, String identifier, Integer floors) throws
                                                                                                  NotFoundException,
                                                                                                  InvalidFieldException,
                                                                                                  ConflictException {
        block.update(identifier, floors);

        condominium.addBlock(block, this::checkDuplicate);

        blockRepository.save(block);

        return block;
    }

    private boolean checkDuplicate(Block block, Condominium condominium) {
        return this.blockRepository.existsWithinCondominiumWithSameIdentifier(block, condominium);
    }
}
