package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;

public interface CheckBlock {
    boolean checkDuplicate(Block block);
}
