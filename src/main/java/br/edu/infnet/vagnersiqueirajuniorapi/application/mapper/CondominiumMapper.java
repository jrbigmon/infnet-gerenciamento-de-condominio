package br.edu.infnet.vagnersiqueirajuniorapi.application.mapper;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.AddressResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CondominiumResponseDto;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.Address;

public class CondominiumMapper {
    public CondominiumResponseDto map(Condominium condominium) {
        Address address = condominium.getAddress();
        return new CondominiumResponseDto(
                condominium.getId(), condominium.getName(),
                new AddressResponseDto(
                        address.getStreet(), address.getCity(), address.getState(), address.getZipcode(),
                        address.getCountry()
                )
        );
    }
}
