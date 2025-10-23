package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CreateBlockDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.BlockService;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @PostMapping("/condominiums/{id}/blocks")
    public Block create(@PathVariable UUID id, @RequestBody CreateBlockDto input) {
        return blockService.create(id, input.identifier(), input.floors());
    }
}
