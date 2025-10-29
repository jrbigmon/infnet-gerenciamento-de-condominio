package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IApartmentRepository;

public record DeleteApartmentUseCase(IApartmentRepository apartmentRepository) {
    public void execute(Apartment apartment) {
        apartmentRepository.delete(apartment);
    }
}
