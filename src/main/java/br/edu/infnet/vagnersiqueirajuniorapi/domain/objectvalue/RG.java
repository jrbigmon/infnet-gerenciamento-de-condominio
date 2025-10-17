package br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RG {
    private String value;

    public boolean isValid() {
        String rg = this.value;

        rg = rg.toUpperCase().replaceAll("[^\\dX]", "");

        if (rg.length() < 8 || rg.length() > 9) {
            return false;
        }

        return rg.matches("\\d{8}[\\dX]?");
    }
}
