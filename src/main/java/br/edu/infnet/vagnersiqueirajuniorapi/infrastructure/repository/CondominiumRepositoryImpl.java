package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondominiumRepositoryImpl implements ICondominiumRepository {

    private final List<Condominium> storage = new ArrayList<>();

    @Override
    public void save(Condominium condominium) {
        storage.add(condominium);
    }

    @Override
    public boolean existsWithTheSameNameAndAddress(Condominium condominium) {
        return storage.stream().anyMatch(c -> c.getName().equalsIgnoreCase(condominium.getName()) && c.getAddress().equals(condominium.getAddress()));
    }
}
