package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CreateCondominiumDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.CondominiumService;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CondominiumController {

    private final CondominiumService condominiumService;

    public CondominiumController(CondominiumService condominiumService) {
        this.condominiumService = condominiumService;
    }

    @PostMapping("/condominiums")
    Condominium create(@RequestBody CreateCondominiumDto input) {
        return condominiumService.create(input.name(), input.street(), input.city(), input.state(), input.zipcode(), input.country());
    }
}
