package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.CPF;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.RG;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.service.CheckResident;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Apartment {
    private UUID id;
    private String identifier;
    private Block block;

    public void isValid() throws InvalidFieldException {
        if (this.identifier.isEmpty()) {
            throw new InvalidFieldException("Apartment identifier is required");
        }
    }

    public Resident createResident(String name, CPF cpf, RG rg, LocalDateTime birthDate) throws InvalidFieldException {
        Resident resident = new Resident();
        resident.setId(UUID.randomUUID());
        resident.setName(name);
        resident.setCpf(cpf);
        resident.setRg(rg);
        resident.setBirthDate(birthDate);
        resident.isValid();
        return resident;
    }

    public void addResident(Resident resident, CheckResident checker) throws ConflictException {
        boolean isDuplicated = checker.checkDuplicate(resident);
        boolean livingInAnotherApartment = checker.livingInAnotherApartment(resident);

        if (isDuplicated) {
            throw new ConflictException("Duplicated resident");
        }

        if (livingInAnotherApartment) {
            throw new ConflictException("Living In Another Apartment");
        }

        resident.setApartment(this);
    }
}
