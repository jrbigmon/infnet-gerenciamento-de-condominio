package br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String number;

    public boolean isValid() {
        return !street.isEmpty() && !city.isEmpty() && !state.isEmpty() && !zipcode.isEmpty() && !country.isEmpty() &&
               !number.isEmpty();
    }
}
