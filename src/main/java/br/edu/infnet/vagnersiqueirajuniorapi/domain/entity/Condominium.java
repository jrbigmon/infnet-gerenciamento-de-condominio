package br.edu.infnet.vagnersiqueirajuniorapi.domain.entity;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.ConflictException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.objectvalue.Address;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.service.CheckBlock;
import lombok.Data;

import java.util.UUID;


@Data
public class Condominium {
    private UUID id;
    private String name;
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
        if (this.name.isEmpty()) {
            throw new InvalidFieldException("Name is required");
        }

        if (this.address == null) {
            throw new InvalidFieldException("Address is required");
        }

        if (!this.address.isValid()) {
            throw new InvalidFieldException("Address is not valid");
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
            throw new ConflictException("Duplicate Block");
        }

        block.setCondominium(this);
    }
}
