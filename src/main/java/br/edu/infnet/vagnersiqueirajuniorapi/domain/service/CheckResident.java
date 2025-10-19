package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Resident;

public interface CheckResident {
    boolean checkDuplicate(Resident resident);

    boolean livingInAnotherApartment(Resident resident);
}
