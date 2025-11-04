package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.impl.pg;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.jpa.BlockRepositoryJpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Profile("!dev")
public class BlockRepositoryImpl implements IBlockRepository {
    private final BlockRepositoryJpa repositoryJpa;

    public BlockRepositoryImpl(BlockRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public void save(Block block) {
        repositoryJpa.save(block);
    }

    @Override
    public boolean existsWithinCondominiumWithSameIdentifier(Block block, Condominium condominium) {
        return repositoryJpa.existsByIdentifierAndCondominium_Id(block.getIdentifier(), condominium.getId());
    }

    @Override
    public Block findByIdAndCondominiumId(UUID id, Condominium condominium) {
        return repositoryJpa.findByIdAndCondominium_Id(id, condominium.getId()).orElse(null);
    }

    @Override
    public List<Block> findAllByCondominium(Condominium condominium) {
        return repositoryJpa.findAllByCondominium_Id(condominium.getId());
    }

    @Override
    public void deleteAllByCondominium(Condominium condominium) {
        repositoryJpa.deleteAllByCondominium_Id(condominium.getId());
    }

    @Override
    public void delete(Block block) {
        repositoryJpa.delete(block);
    }
}
