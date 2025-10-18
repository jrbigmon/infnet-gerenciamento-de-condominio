package br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public boolean isValid() {
        return !street.isEmpty() && !city.isEmpty() && !state.isEmpty() && !zipcode.isEmpty() && !country.isEmpty();
    }
}
