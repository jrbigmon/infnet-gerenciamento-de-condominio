package br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CPF {
    private String value;

    public boolean isValid() {
        String cpf = this.value;

        cpf = cpf.replaceAll("[^\\d]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0, sum2 = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(cpf.charAt(i));
                sum += digit * (10 - i);
                sum2 += digit * (11 - i);
            }

            int dv1 = sum % 11;
            dv1 = (dv1 < 2) ? 0 : 11 - dv1;

            sum2 += dv1 * 2;
            int dv2 = sum2 % 11;
            dv2 = (dv2 < 2) ? 0 : 11 - dv2;

            return dv1 == Character.getNumericValue(cpf.charAt(9)) && dv2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }
}
