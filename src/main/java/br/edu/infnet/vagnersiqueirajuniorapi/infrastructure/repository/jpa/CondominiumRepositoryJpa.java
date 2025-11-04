package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository.jpa;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CondominiumRepositoryJpa extends JpaRepository<Condominium, UUID> {
    @Query("""
                SELECT COUNT(c) > 0
                FROM Condominium c
                WHERE c.name = :#{#condominium.name}
                  AND c.address.street = :#{#condominium.address.street}
                  AND c.address.number = :#{#condominium.address.number}
                  AND c.address.city = :#{#condominium.address.city}
                  AND c.address.state = :#{#condominium.address.state}
                  AND c.address.zipcode = :#{#condominium.address.zipcode}
            """)
    boolean existsByNameAndAddress(@Param("condominium") Condominium condominium);
}
