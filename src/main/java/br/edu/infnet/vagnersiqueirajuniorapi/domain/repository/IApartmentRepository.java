package br.edu.infnet.vagnersiqueirajuniorapi.domain.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;

import java.util.List;
import java.util.UUID;

public interface IApartmentRepository {
    void save(Apartment apartment);

    boolean existsWithinBlockWithSameIdentifier(Apartment apartment, Block block);

    List<Apartment> findAllByBlock(Block block);

    void deleteAllByCondominium(Condominium condominium);

    void deleteAllByBlock(Block block);

    Apartment findByIdAndBlockId(UUID id, Block block);

    void delete(Apartment apartment);
}
