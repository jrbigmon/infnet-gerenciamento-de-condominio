package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlockService {
    private final GetCondominiumUseCase getCondominiumUseCase;
    private final CreateBlockUseCase createBlockUseCase;
    private final UpdateBlockUseCase updateBlockUseCase;
    private final ListBlockUseCase listBlockUseCase;
    private final GetBlockUseCase getBlockUseCase;
    private final DeleteBlockUseCase deleteBlockUseCase;

    public BlockService(CreateBlockUseCase createBlockUseCase, UpdateBlockUseCase updateBlockUseCase,
                        ListBlockUseCase listBlockUseCase, GetCondominiumUseCase getCondominiumUseCase,
                        GetBlockUseCase getBlockUseCase, DeleteBlockUseCase deleteBlockUseCase) {
        this.createBlockUseCase = createBlockUseCase;
        this.updateBlockUseCase = updateBlockUseCase;
        this.listBlockUseCase = listBlockUseCase;
        this.getCondominiumUseCase = getCondominiumUseCase;
        this.getBlockUseCase = getBlockUseCase;
        this.deleteBlockUseCase = deleteBlockUseCase;
    }

    public Block create(UUID condominiumId, String identifier, Integer floors) throws NotFoundException,
                                                                                      InvalidFieldException,
                                                                                      ConflictException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        return createBlockUseCase.execute(condominium, identifier, floors);
    }

    public Block update(UUID condominiumId, UUID blockId, String identifier, Integer floors) throws NotFoundException,
                                                                                                    InvalidFieldException,
                                                                                                    ConflictException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        return updateBlockUseCase.execute(condominium, block, identifier, floors);
    }

    public List<Block> list(UUID condominiumId) throws NotFoundException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        return listBlockUseCase.execute(condominium);
    }

    public Block get(UUID condominiumId, UUID blockId) throws NotFoundException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        return getBlockUseCase.execute(condominium, blockId);
    }

    public void delete(UUID condominiumId, UUID blockId) throws NotFoundException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        deleteBlockUseCase.execute(block);
    }
}
