package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                                     !b.getId().equals(block.getId()) &&
                                     b.getCondominium().getId().equals(condominium.getId()));
    }

    @Override
    public Block findByIdAndCondominiumId(UUID id, Condominium condominium) {
        return storage.stream()
                      .filter(b -> b.getId().equals(id) && b.getCondominium().getId().equals(condominium.getId()))
                      .findFirst()
                      .orElse(null);
    }

    @Override
    public List<Block> findAllByCondominium(Condominium condominium) {
        return storage.stream().filter(b -> b.getCondominium().getId().equals(condominium.getId())).toList();
    }

    @Override
    public void deleteAllByCondominium(Condominium condominium) {
        List<Block> blocks = findAllByCondominium(condominium);
        for (Block block : blocks) {
            storage.remove(block);
        }
    }

    @Override
    public void delete(Block block) {
        storage.remove(block);
    }
}
