package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.service.CheckApartment;
import lombok.Data;

import java.util.UUID;

@Data
public class Block {
    private UUID id;
    private String identifier;
    private Integer floors;
    private Condominium condominium;

    public void isValid() throws InvalidFieldException {
        if (this.identifier.isEmpty()) {
            throw new InvalidFieldException("Block Identifier is required");
        }

        if (this.floors == null) {
            throw new InvalidFieldException("Block Floors is required");
        }

        if (this.floors <= 0) {
            throw new InvalidFieldException("Block Floors must be a positive integer");
        }
    }

    public Apartment createApartment(String identifier) throws InvalidFieldException {
        Apartment apartment = new Apartment();
        apartment.setId(UUID.randomUUID());
        apartment.setIdentifier(identifier);
        apartment.isValid();
        return apartment;
    }

    public void addApartment(Apartment apartment, CheckApartment checker) throws ConflictException {
        boolean isDuplicate = checker.checkDuplicate(apartment);

        if (isDuplicate) {
            throw new ConflictException("Duplicate Apartment");
        }

        apartment.setBlock(this);
    }
}
