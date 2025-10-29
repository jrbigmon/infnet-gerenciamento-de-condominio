package br.edu.infnet.vagnersiqueirajuniorapi.domain.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;

public interface IApartmentRepository {
    void save(Apartment apartment);

    boolean existsWithinBlockWithSameIdentifier(Apartment apartment, Block block);
}
