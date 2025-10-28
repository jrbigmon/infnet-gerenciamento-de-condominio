package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;

import java.util.List;

public record ListBlockUseCase(IBlockRepository blockRepository) {
    public List<Block> execute(Condominium condominium) throws NotFoundException {
        return blockRepository.findAllByCondominium(condominium);
    }
}
