package br.edu.infnet.vagnersiqueirajuniorapi.domain.service;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Block;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.entity.Condominium;

@FunctionalInterface
public interface CheckBlock {
    boolean checkDuplicate(Block block, Condominium condominium);
}
