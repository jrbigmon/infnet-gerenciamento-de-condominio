package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.repository;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ApartmentRepositoryImpl implements IApartmentRepository {
    private final List<Apartment> storage = new ArrayList<>();

    @Override
    public void save(Apartment apartment) {
        storage.add(apartment);
    }

    @Override
    public boolean existsWithinBlockWithSameIdentifier(Apartment apartment, Block block) {
        return storage.stream()
                      .anyMatch(a -> a.getIdentifier().equals(apartment.getIdentifier()) &&
                                     !a.getId().equals(apartment.getId()) &&
                                     a.getBlock().getId().equals(block.getId()));
    }

    @Override
    public List<Apartment> findAllByBlock(Block block) {
        return storage.stream().filter(a -> a.getBlock().getId().equals(block.getId())).toList();
    }

    @Override
    public void deleteAllByCondominium(Condominium condominium) {
        List<Apartment> apartments = storage.stream()
                                            .filter(a -> a.getBlock()
                                                          .getCondominium()
                                                          .getId()
                                                          .equals(condominium.getId()))
                                            .toList();
        storage.removeAll(apartments);
    }

    @Override
    public void deleteAllByBlock(Block block) {
        List<Apartment> apartments = storage.stream().filter(a -> a.getBlock().getId().equals(block.getId())).toList();
        storage.removeAll(apartments);
    }

    @Override
    public Apartment findByIdAndBlockId(UUID id, Block block) {
        return storage.stream().filter(a -> a.getBlock().getId().equals(block.getId())).findFirst().orElse(null);

    }


}
