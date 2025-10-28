package br.edu.infnet.vagnersiqueirajuniorapi.application.controller;

import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.CreateBlockDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.dto.UpdateBlockDto;
import br.edu.infnet.vagnersiqueirajuniorapi.application.service.BlockService;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/condominiums/{id}/blocks/{blockId}")
    public Block update(@PathVariable UUID id, @PathVariable UUID blockId, @RequestBody UpdateBlockDto input) {
        return blockService.update(id, blockId, input.identifier(), input.floors());
    }

    @GetMapping("/condominiums/{id}/blocks/{blockId}")
    public Block get(@PathVariable UUID id, @PathVariable UUID blockId) {
        return blockService.get(id, blockId);
    }

    @GetMapping("/condominiums/{id}/blocks")
    public List<Block> findAll(@PathVariable UUID id) {
        return blockService.list(id);
    }

    @DeleteMapping("/condominiums/{id}/blocks/{blockId}")
    public void delete(@PathVariable UUID id, @PathVariable UUID blockId) {
        blockService.delete(id, blockId);
    }
}
