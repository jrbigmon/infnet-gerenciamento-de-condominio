package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.application.types.CreateApartmentType;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.CreateApartmentUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GenerateApartmentsUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GetBlockUseCase;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.GetCondominiumUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApartmentService {
    private final GenerateApartmentsUseCase generateApartmentsUseCase;
    private final GetBlockUseCase getBlockUseCase;
    private final GetCondominiumUseCase getCondominiumUseCase;
    private final CreateApartmentUseCase createApartmentUseCase;

    public ApartmentService(GenerateApartmentsUseCase generate, GetBlockUseCase getBlockUseCase,
                            GetCondominiumUseCase getCondominiumUseCase,
                            CreateApartmentUseCase createApartmentUseCase) {
        this.generateApartmentsUseCase = generate;
        this.getBlockUseCase = getBlockUseCase;
        this.getCondominiumUseCase = getCondominiumUseCase;
        this.createApartmentUseCase = createApartmentUseCase;
    }

    public List<Apartment> generate(UUID condominiumId, UUID blockId, Integer floorStart, Integer floorEnd,
                                    Integer apartmentQuantity) {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        return generateApartmentsUseCase.execute(block, floorStart, floorEnd, apartmentQuantity);
    }

    public void createList(UUID condominiumId, UUID blockId, List<CreateApartmentType> apartments) throws
                                                                                                   ConflictException,
                                                                                                   InvalidFieldException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        apartments.forEach(a -> createApartmentUseCase.execute(block, a.identifier(), a.floor()));
    }
}
