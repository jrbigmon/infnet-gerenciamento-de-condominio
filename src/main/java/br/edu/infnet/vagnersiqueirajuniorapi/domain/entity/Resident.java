package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.CPF;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.RG;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Resident {
    private UUID id;
    private String name;
    private CPF cpf;
    private RG rg;
    private LocalDateTime birthDate;
    private Apartment apartment;

    public void isValid() throws InvalidFieldException {
        if (name.isEmpty()) {
            throw new InvalidFieldException("Name is required");
        }

        if (cpf == null) {
            throw new InvalidFieldException("CPF is required");
        }

        if (!cpf.isValid()) {
            throw new InvalidFieldException("CPF is not valid");
        }

        if (rg == null) {
            throw new InvalidFieldException("RG is required");
        }

        if (!rg.isValid()) {
            throw new InvalidFieldException("RG is not valid");
        }

        if (birthDate == null) {
            throw new InvalidFieldException("Birth date is required");
        }

        if (birthDate.isAfter(LocalDateTime.now())) {
            {
                throw new InvalidFieldException("Birth date is after now");
            }
        }
    }
}
