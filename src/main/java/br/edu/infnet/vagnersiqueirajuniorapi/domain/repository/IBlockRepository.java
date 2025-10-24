package br.edu.infnet.vagnersiqueirajuniorapi.domain.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;

import java.util.List;
import java.util.UUID;

public interface IBlockRepository {
    void save(Block block);
    boolean existsWithinCondominiumWithSameIdentifier(Block block, Condominium condominium);
    Block findByIdAndCondominiumId(UUID id, Condominium condominium);
    List<Block> findAllByCondominium(Condominium condominium);
    void deleteAllByCondominium(Condominium condominium);
    void delete(Block block);
}
