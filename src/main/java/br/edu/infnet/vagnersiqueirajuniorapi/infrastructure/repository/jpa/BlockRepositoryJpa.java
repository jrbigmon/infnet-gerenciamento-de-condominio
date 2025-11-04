package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.jpa;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlockRepositoryJpa extends JpaRepository<Block, UUID> {
    boolean existsByIdentifierAndCondominium_Id(String identifier, UUID condominiumId);

    Optional<Block> findByIdAndCondominium_Id(UUID id, UUID condominiumId);

    void deleteAllByCondominium_Id(UUID condominiumId);

    List<Block> findAllByCondominium_Id(UUID condominiumId);
}
