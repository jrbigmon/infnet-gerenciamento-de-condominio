package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.CreateBlockUseCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlockService {
    private final CreateBlockUseCase createBlockUseCase;

    public BlockService(CreateBlockUseCase createBlockUseCase) {
        this.createBlockUseCase = createBlockUseCase;
    }

    public Block create(UUID condominiumId, String identifier, Integer floors) {
        return createBlockUseCase.execute(condominiumId, identifier, floors);
    }
}
