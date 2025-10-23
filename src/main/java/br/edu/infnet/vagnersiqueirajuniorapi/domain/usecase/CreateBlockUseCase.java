package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;

import java.util.UUID;

public record CreateBlockUseCase(ICondominiumRepository condominiumRepository, IBlockRepository blockRepository) {
    public Block execute(UUID condominiumId, String identifier, Integer floors) throws NotFoundException,
                                                                                       ConflictException {
        Condominium condominium = condominiumRepository.findById(condominiumId);

        if (condominium == null) {
            throw new NotFoundException("Condominium not found");
        }

        Block block = condominium.createBlock(identifier, floors);

        condominium.addBlock(block, this::checkDuplicate);

        blockRepository.save(block);

        return block;
    }

    private boolean checkDuplicate(Block block, Condominium condominium) {
        return this.blockRepository.existsWithinCondominiumWithSameIdentifier(block, condominium);
    }
}
