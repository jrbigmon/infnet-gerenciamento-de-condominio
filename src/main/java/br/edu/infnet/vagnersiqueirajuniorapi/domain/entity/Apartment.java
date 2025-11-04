package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.CPF;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.RG;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.service.CheckResident;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Apartment {

    @Id
    private UUID id;
    private String identifier;
    private Integer floor;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;

    public void isValid() throws InvalidFieldException {
        InvalidFieldException exception = new InvalidFieldException("apartment invalid fields");

        if (this.identifier.isEmpty()) {
            exception.putError("identifier", "is required");
        }

        if (this.floor == null) {
            exception.putError("floor", "is required");
        }

        if (this.floor < 0) {
            exception.putError("floor", "must be greater than or equal to 0");
        }

        if (exception.isNotEmpty()) {
            throw exception;
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
            throw new ConflictException("duplicated resident");
        }

        if (livingInAnotherApartment) {
            throw new ConflictException("living In Another Apartment");
        }

        resident.setApartment(this);
    }

    public void update(String identifier, Integer floor) throws InvalidFieldException {
        this.identifier = identifier;
        this.floor = floor;
        this.isValid();
    }
}
