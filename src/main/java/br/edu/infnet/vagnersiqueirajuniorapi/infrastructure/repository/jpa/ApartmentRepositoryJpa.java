package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.jpa;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApartmentRepositoryJpa extends JpaRepository<Apartment, UUID> {
    boolean existsByIdentifierAndBlock_Id(String identifier, UUID blockId);

    List<Apartment> findAllByBlock_Id(UUID blockId);

    void deleteAllByBlock_Condominium_Id(UUID condominiumId);

    void deleteAllByBlock_Id(UUID blockId);

    Optional<Apartment> findByIdAndBlock_Id(UUID apartmentId, UUID blockId);
}
