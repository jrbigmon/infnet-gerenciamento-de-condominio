package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Resident;

public interface CheckResident {
    public boolean checkDuplicate(Resident resident);

    public boolean livingInAnotherApartment(Resident resident);
}
