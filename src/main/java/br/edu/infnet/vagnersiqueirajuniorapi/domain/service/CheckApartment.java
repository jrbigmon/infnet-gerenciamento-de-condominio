package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;

public interface CheckApartment {
    boolean checkDuplicate(Apartment apartment);
}
