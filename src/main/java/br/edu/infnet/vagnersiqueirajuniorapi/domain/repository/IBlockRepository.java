package br.edu.infnet.vagnersiqueirajuniorapi.domain.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;

public interface IBlockRepository {
    void save(Block block);
    boolean existsWithinCondominiumWithSameIdentifier(Block block, Condominium condominium);
}
