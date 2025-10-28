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
        InvalidFieldException exception = new InvalidFieldException("resident invalid fields");

        if (name.isEmpty()) {
            exception.putError("name", "is required");
        }

        if (cpf == null) {
            exception.putError("cpf", "is required");
        } else if (!cpf.isValid()) {
            exception.putError("cpf", "is not valid");
        }

        if (rg == null) {
            exception.putError("rg", "is required");
        } else if (!rg.isValid()) {
            exception.putError("rg", "is not valid");
        }

        if (birthDate == null) {
            exception.putError("birthDate", "is required");
        } else if (birthDate.isAfter(LocalDateTime.now())) {
            {
                exception.putError("birthDate", "must be before now");
            }
        }

        if (exception.isNotEmpty()) {
            throw exception;
        }
    }
}
