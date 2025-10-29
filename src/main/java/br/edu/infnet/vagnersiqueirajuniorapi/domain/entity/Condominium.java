package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.Address;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.service.CheckBlock;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
public class Condominium {

    @Id
    private UUID id;
    private String name;

    @Embedded
    private Address address;

    public static Condominium create(String name, Address address) throws InvalidFieldException {
        Condominium condominium = new Condominium();
        condominium.setId(UUID.randomUUID());
        condominium.setName(name);
        condominium.setAddress(address);
        condominium.isValid();
        return condominium;
    }

    public void isValid() throws InvalidFieldException {
        InvalidFieldException exception = new InvalidFieldException("condominium invalid fields");

        if (this.name.isEmpty()) {
            exception.putError("name", "is required");
        }

        if (this.address == null) {
            exception.putError("address", "is required");
        } else if (!this.address.isValid()) {
            exception.putError("address", "is not valid");
        }

        if (exception.isNotEmpty()) {
            throw exception;
        }
    }

    public Block createBlock(String identifier, Integer floors) throws InvalidFieldException {
        Block block = new Block();
        block.setId(UUID.randomUUID());
        block.setIdentifier(identifier);
        block.setFloors(floors);
        block.isValid();
        return block;
    }

    public void addBlock(Block block, CheckBlock checker) throws ConflictException {
        boolean isDuplicate = checker.checkDuplicate(block, this);

        if (isDuplicate) {
            throw new ConflictException("duplicate Block " + block.getIdentifier());
        }

        block.setCondominium(this);
    }
}
