package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.impl.pg;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.jpa.ApartmentRepositoryJpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Profile("!dev")
public class ApartmentRepositoryImpl implements IApartmentRepository {
    private final ApartmentRepositoryJpa repositoryJpa;

    public ApartmentRepositoryImpl(ApartmentRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public void save(Apartment apartment) {
        repositoryJpa.save(apartment);
    }

    @Override
    public boolean existsWithinBlockWithSameIdentifier(Apartment apartment, Block block) {
        return repositoryJpa.existsByIdentifierAndBlock_Id(apartment.getIdentifier(), block.getId());
    }

    @Override
    public List<Apartment> findAllByBlock(Block block) {
        return repositoryJpa.findAllByBlock_Id(block.getId());
    }

    @Override
    public void deleteAllByCondominium(Condominium condominium) {
        repositoryJpa.deleteAllByBlock_Condominium_Id(condominium.getId());
    }

    @Override
    public void deleteAllByBlock(Block block) {
        repositoryJpa.deleteAllByBlock_Id(block.getId());
    }

    @Override
    public Apartment findByIdAndBlockId(UUID id, Block block) {
        return repositoryJpa.findByIdAndBlock_Id(id, block.getId()).orElse(null);
    }

    @Override
    public void delete(Apartment apartment) {
        repositoryJpa.delete(apartment);
    }
}
