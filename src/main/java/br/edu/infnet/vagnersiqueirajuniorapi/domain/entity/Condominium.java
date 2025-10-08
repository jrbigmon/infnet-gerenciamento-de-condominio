package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.Address;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Condominium {
    private Long id;
    private String name;
    private Address address;
}
