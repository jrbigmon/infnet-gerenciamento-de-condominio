package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;

public interface CheckApartment {
    public boolean checkDuplicate(Apartment apartment);
}
