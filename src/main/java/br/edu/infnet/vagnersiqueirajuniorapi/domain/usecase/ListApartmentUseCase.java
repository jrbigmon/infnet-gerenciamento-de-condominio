package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;

import java.util.List;

public record ListApartmentUseCase(IApartmentRepository apartmentRepository) {
    public List<Apartment> execute(Block block) {
        return apartmentRepository.findAllByBlock(block);
    }
}
