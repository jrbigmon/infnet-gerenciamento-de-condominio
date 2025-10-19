package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CreateCondominiumDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.UpdateCondominiumDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.CondominiumService;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CondominiumController {

    private final CondominiumService condominiumService;

    public CondominiumController(CondominiumService condominiumService) {
        this.condominiumService = condominiumService;
    }

    @PostMapping("/condominiums")
    public Condominium create(@RequestBody CreateCondominiumDto input) {
        return condominiumService.create(input.name(), input.street(), input.city(), input.state(), input.zipcode(), input.country());
    }

    @PutMapping("/condominiums/{id}")
     public Condominium update(@PathVariable UUID id, @RequestBody UpdateCondominiumDto input)  {
        return condominiumService.update(id, input.name(), input.street(), input.city(), input.state(), input.zipcode(), input.country());
    }
}
