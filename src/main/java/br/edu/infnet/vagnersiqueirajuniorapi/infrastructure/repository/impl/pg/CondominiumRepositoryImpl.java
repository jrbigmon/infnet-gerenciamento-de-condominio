package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.impl.pg;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.jpa.CondominiumRepositoryJpa;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Profile("!dev")
public class CondominiumRepositoryImpl implements ICondominiumRepository {

    private final CondominiumRepositoryJpa repositoryJpa;

    public CondominiumRepositoryImpl(CondominiumRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public void save(Condominium condominium) {
        repositoryJpa.save(condominium);
    }

    @Override
    public boolean existsWithTheSameNameAndAddress(Condominium condominium) {
        return repositoryJpa.existsByNameAndAddress(condominium);
    }

    @Override
    public Condominium findById(UUID id) {
        return repositoryJpa.findById(id).orElse(null);
    }

    @Override
    public List<Condominium> findAll() {
        return repositoryJpa.findAll();
    }

    @Override
    public void delete(Condominium condominium) {
        repositoryJpa.delete(condominium);
    }
}
