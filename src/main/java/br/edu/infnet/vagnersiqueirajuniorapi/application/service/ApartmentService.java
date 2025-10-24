package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GenerateApartmentsUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GetBlockUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GetCondominiumUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApartmentService {
    private final GenerateApartmentsUseCase createApartmentsUseCase;
    private final GetBlockUseCase getBlockUseCase;
    private final GetCondominiumUseCase getCondominiumUseCase;

    public ApartmentService(GenerateApartmentsUseCase create, GetBlockUseCase getBlockUseCase,
                            GetCondominiumUseCase getCondominiumUseCase) {
        this.createApartmentsUseCase = create;
        this.getBlockUseCase = getBlockUseCase;
        this.getCondominiumUseCase = getCondominiumUseCase;
    }

    public List<Apartment> generate(UUID condominiumId, UUID blockId, Integer floorStart, Integer floorEnd,
                                  Integer apartmentQuantity) {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        return createApartmentsUseCase.execute(block, floorStart, floorEnd, apartmentQuantity);
    }
}
