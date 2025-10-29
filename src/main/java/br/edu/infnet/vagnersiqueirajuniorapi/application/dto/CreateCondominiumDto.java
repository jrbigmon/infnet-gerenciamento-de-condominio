package br.edu.infnet.vagnersiqueirajuniorapi.application.dto;

public record CreateCondominiumDto(String name, String street, String city, String state, String zipcode,
                                   String country, String number) {

}
