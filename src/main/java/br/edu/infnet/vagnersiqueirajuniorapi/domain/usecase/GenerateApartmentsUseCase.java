package br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Apartment;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.utils.Alphabetic;

import java.util.ArrayList;
import java.util.List;

public record GenerateApartmentsUseCase() {
    public List<Apartment> execute(Block block, Integer floorStart, Integer floorEnd, Integer apartmentQuantity) {
        List<Apartment> apartments = new ArrayList<>();

        for (int floor = floorStart; floor <= floorEnd; floor++) {
            for (int apartmentNumber = 1; apartmentNumber <= apartmentQuantity; apartmentNumber++) {
                Apartment apartment = block.createApartment(generateApartmentNumber(floor, apartmentNumber), floor);
                apartments.add(apartment);
            }
        }

        return apartments;
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
