package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.service.CheckApartment;
import lombok.Data;

import java.util.UUID;

import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.MAX_FLOORS;
import static br.edu.infnet.vagnersiqueirajuniorapi.domain.constant.BlockConstants.MIN_FLOORS;

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
        } else if (this.floors <= MIN_FLOORS) {
            exception.putError("floors", "must be greater than or equal to " + MIN_FLOORS);
        } else if (this.floors > MAX_FLOORS) {
            exception.putError("floors", "must be less than " + MAX_FLOORS);
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
