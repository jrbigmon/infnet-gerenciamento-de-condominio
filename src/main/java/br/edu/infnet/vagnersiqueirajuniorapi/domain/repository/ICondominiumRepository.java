package br.edu.infnet.vagnersiqueirajuniorapi.domain.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;

import java.util.List;
import java.util.UUID;

public interface ICondominiumRepository {
    void save(Condominium condominium);

    boolean existsWithTheSameNameAndAddress(Condominium condominium);

    Condominium findById(UUID id);

    List<Condominium> findAll();

    void delete(Condominium condominium);
}
