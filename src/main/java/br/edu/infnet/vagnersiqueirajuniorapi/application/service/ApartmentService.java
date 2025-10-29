package br.edu.infnet.vagnersiqueirajuniorapi.application.service;

import br.edu.infnet.vagnersiqueirajuniorapi.application.types.CreateApartmentType;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApartmentService {
    private final GenerateApartmentsUseCase generateApartmentsUseCase;
    private final GetBlockUseCase getBlockUseCase;
    private final GetCondominiumUseCase getCondominiumUseCase;
    private final CreateApartmentUseCase createApartmentUseCase;
    private final ListApartmentUseCase listApartmentUseCase;
    private final UpdateApartmentUseCase updateApartmentUseCase;
    private final GetApartmentUseCase getApartmentUseCase;

    public ApartmentService(GenerateApartmentsUseCase generate, GetBlockUseCase getBlockUseCase,
                            GetCondominiumUseCase getCondominiumUseCase, CreateApartmentUseCase createApartmentUseCase,
                            ListApartmentUseCase list, UpdateApartmentUseCase updateApartmentUseCase,
                            GetApartmentUseCase getApartmentUseCase) {
        this.generateApartmentsUseCase = generate;
        this.getBlockUseCase = getBlockUseCase;
        this.getCondominiumUseCase = getCondominiumUseCase;
        this.createApartmentUseCase = createApartmentUseCase;
        this.listApartmentUseCase = list;
        this.updateApartmentUseCase = updateApartmentUseCase;
        this.getApartmentUseCase = getApartmentUseCase;
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

    public List<Apartment> list(UUID condominiumId, UUID blockId) throws NotFoundException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        return listApartmentUseCase.execute(block);
    }

    public Apartment update(UUID condominiumId, UUID blockId, UUID apartmentId, String identifier, Integer floor) throws
                                                                                                                  NotFoundException,
                                                                                                                  InvalidFieldException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        Apartment apartment = getApartmentUseCase.execute(block, apartmentId);
        return updateApartmentUseCase.execute(block, apartment, identifier, floor);
    }

    public Apartment get(UUID condominiumId, UUID blockId, UUID apartmentId) throws NotFoundException {
        Condominium condominium = getCondominiumUseCase.execute(condominiumId);
        Block block = getBlockUseCase.execute(condominium, blockId);
        return getApartmentUseCase.execute(block, apartmentId);
    }
}
