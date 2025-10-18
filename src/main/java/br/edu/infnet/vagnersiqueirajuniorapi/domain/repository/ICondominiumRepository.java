package br.edu.infnet.vagnersiqueirajuniorapi.domain.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;

public interface ICondominiumRepository {
    void save(Condominium condominium);
    boolean existsWithTheSameNameAndAddress(Condominium condominium);
}
