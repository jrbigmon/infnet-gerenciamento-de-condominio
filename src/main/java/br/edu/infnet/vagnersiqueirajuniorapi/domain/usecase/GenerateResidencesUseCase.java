package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.NotFoundException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.generateresidencesconfig.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record GenerateResidencesUseCase(ICondominiumRepository condominiumRepository) {
    public void execute(UUID condominiumId ,ResidenceConfig config) throws NotFoundException {
        Condominium condominium = condominiumRepository.findById(condominiumId);

        if (condominium == null) {
            throw new NotFoundException("Condominium not found");
        }

        if (config == null) {
            throw new InvalidFieldException("Config is required");
        }

        TowerConfig tower = config.tower();
        FloorConfig floor = config.floor();
        ApartmentConfig apartment = config.apartment();

        if (floor == null) {
            throw new InvalidFieldException("Floor config is required");
        }

        if (apartment == null) {
            throw new InvalidFieldException("Apartment config is required");
        }

        OperatorConfig[] list = new OperatorConfig[3];

        if (tower != null && tower.config() != null) {
            list[tower.config().position()] = tower.config();
        }

        list[floor.config().position()] = floor.config();
        list[apartment.config().position()] = apartment.config();

        List<Apartment> listApartment = new ArrayList<>();
        for (int i = 0; i < floor.quantity(); i++) {
            for (int j = 0; j < apartment.quantity(); j++) {

            }
        }
    }
}
