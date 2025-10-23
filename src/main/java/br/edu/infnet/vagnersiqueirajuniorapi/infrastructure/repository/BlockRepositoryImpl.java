package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlockRepositoryImpl implements IBlockRepository {
    private final List<Block> storage = new ArrayList<>();

    @Override
    public void save(Block block) {
        storage.add(block);
    }

    @Override
    public boolean existsWithinCondominiumWithSameIdentifier(Block block, Condominium condominium) {
        return storage.stream()
                      .anyMatch(b -> b.getIdentifier().equals(block.getIdentifier()) &&
                                     b.getCondominium().getId().equals(condominium.getId()));
    }
}
