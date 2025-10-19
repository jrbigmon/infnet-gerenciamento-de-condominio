package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CondominiumRepositoryImpl implements ICondominiumRepository {

    private final List<Condominium> storage = new ArrayList<>();

    @Override
    public void save(Condominium condominium) {
        storage.add(condominium);
    }

    @Override
    public boolean existsWithTheSameNameAndAddress(Condominium condominium) {
        return storage.stream().anyMatch(c -> c.getName().equalsIgnoreCase(condominium.getName()) && c.getAddress().equals(condominium.getAddress()) && !c.getId().equals(condominium.getId()));
    }

    @Override
    public Condominium findById(UUID id) {
        return storage.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Condominium> findAll() {
        return storage;
    }
}
