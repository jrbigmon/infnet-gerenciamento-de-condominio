package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;

public interface CheckApartment {
    boolean checkDuplicate(Apartment apartment, Block block);
}
