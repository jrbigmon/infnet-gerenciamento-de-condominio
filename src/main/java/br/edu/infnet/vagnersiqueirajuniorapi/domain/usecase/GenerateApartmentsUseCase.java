package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.exception.InvalidFieldException;
import br.edu.infnet.vagnersiqueirajuniorapi.utils.Alphabetic;

import java.util.ArrayList;
import java.util.List;

public record GenerateApartmentsUseCase() {
    public List<Apartment> execute(Block block, Integer floorStart, Integer floorEnd, Integer apartmentQuantity) {
        InvalidFieldException exception = validate(floorStart, floorEnd, apartmentQuantity);

        if (exception.isNotEmpty()) {
            throw exception;
        }

        List<Apartment> apartments = new ArrayList<>();

        for (int floor = floorStart; floor <= floorEnd; floor++) {
            for (int apartmentNumber = 1; apartmentNumber <= apartmentQuantity; apartmentNumber++) {
                Apartment apartment = block.createApartment(generateApartmentNumber(floor, apartmentNumber), floor);
                apartments.add(apartment);
            }
        }

        return apartments;
    }

    private InvalidFieldException validate(Integer floorStart, Integer floorEnd, Integer apartmentQuantity) {
        InvalidFieldException exception = new InvalidFieldException("Generate apartments invalid fields");

        if (floorEnd < floorStart) {
            exception.putError("floorEnd", "floorEnd must be greater than floorStart");
        }

        int MAX_FLOORS_PER_BLOCK = 100;
        if (floorEnd > MAX_FLOORS_PER_BLOCK) {
            exception.putError("floorEnd", "Max floor per block is " + MAX_FLOORS_PER_BLOCK);
        }

        int MAX_APARTMENT_PER_FLOOR = 40;
        if (apartmentQuantity > MAX_APARTMENT_PER_FLOOR) {
            exception.putError("apartmentQuantity", "Max apartments per floor is " + MAX_APARTMENT_PER_FLOOR);
        }

        return exception;
    }

    private String generateApartmentNumber(Integer floor, Integer apartmentNumber) {
        String floorString = floor.toString();
        String apartmentString = apartmentNumber.toString();

        if (floorString.length() == 1) {
            floorString = "0" + floorString;
        }

        if (apartmentString.length() == 1) {
            apartmentString = "0" + apartmentString;
        } else {
            String apartmentSuffixLetter = apartmentString.substring(1);
            apartmentString = apartmentString.substring(1) + Alphabetic.get(Integer.parseInt(apartmentSuffixLetter));
        }

        return floorString + apartmentString;
    }
}
