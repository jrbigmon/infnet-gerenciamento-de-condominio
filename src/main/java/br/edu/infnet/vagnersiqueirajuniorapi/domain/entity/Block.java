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
        InvalidFieldException exception = new InvalidFieldException("block invalid fields");

        if (this.identifier.isEmpty()) {
            exception.putError("identifier", "is required");
        }

        if (this.floors == null) {
            exception.putError("floors", "is required");
        } else if (this.floors <= 0) {
            exception.putError("floors", "must be a positive integer");
        }

        if (exception.isNotEmpty()) {
            throw exception;
        }
    }

    public Apartment createApartment(String identifier, Integer floor) throws InvalidFieldException {
        Apartment apartment = new Apartment();
        apartment.setId(UUID.randomUUID());
        apartment.setIdentifier(identifier);
        apartment.setFloor(floor);
        apartment.isValid();
        return apartment;
    }

    public void addApartment(Apartment apartment, CheckApartment checker) throws ConflictException {
        boolean isDuplicate = checker.checkDuplicate(apartment, this);

        if (isDuplicate) {
            throw new ConflictException("duplicate Apartment");
        }

        if (apartment.getFloor() <= 0) {
            throw new ConflictException("floors must be a positive integer");
        }

        if (apartment.getFloor() > this.floors) {
            throw new ConflictException("floor is greater than block's floors");
        }

        apartment.setBlock(this);
    }

    public void update(String identifier, Integer floors) throws InvalidFieldException {
        this.identifier = identifier;
        this.floors = floors;
        this.isValid();
    }
}
