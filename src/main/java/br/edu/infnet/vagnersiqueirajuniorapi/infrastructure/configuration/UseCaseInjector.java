package br.edu.infnet.vagnersiqueirajuniorapi.infrastructure.configuration;

import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.IBlockRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.repository.ICondominiumRepository;
import br.edu.infnet.vagnersiqueirajuniorapi.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseInjector {

    @Bean
    public CreateCondominiumUseCase createCondominiumUseCase(ICondominiumRepository condominiumRepository) {
        return new CreateCondominiumUseCase(condominiumRepository);
    }

    @Bean
    public UpdateCondominiumUseCase updateCondominiumUseCase(ICondominiumRepository condominiumRepository) {
        return new UpdateCondominiumUseCase(condominiumRepository);
    }

    @Bean
    public ListCondominiumsUseCase listCondominiumUseCase(ICondominiumRepository condominiumRepository) {
        return new ListCondominiumsUseCase(condominiumRepository);
    }

    @Bean
    public GetCondominiumUseCase getCondominiumUseCase(ICondominiumRepository condominiumRepository) {
        return new GetCondominiumUseCase(condominiumRepository);
    }

    @Bean
    public CreateBlockUseCase  createBlockUseCase(IBlockRepository blockRepository) {
        return new CreateBlockUseCase(blockRepository);
    }

    @Bean
    public UpdateBlockUseCase updateBlockUseCase(IBlockRepository blockRepository) {
        return new UpdateBlockUseCase(blockRepository);
    }

    @Bean ListBlockUseCase  listBlockUseCase(IBlockRepository blockRepository) {
        return new ListBlockUseCase(blockRepository);
    }

    @Bean GetBlockUseCase getBlockUseCase(IBlockRepository blockRepository) {
        return new GetBlockUseCase(blockRepository);
    }

    @Bean DeleteCondominiumUseCase deleteCondominiumUseCase(ICondominiumRepository condominiumRepository, IBlockRepository blockRepository) {
        return new DeleteCondominiumUseCase(condominiumRepository, blockRepository);
    }

    @Bean DeleteBlockUseCase deleteBlockUseCase(IBlockRepository blockRepository) {
        return new DeleteBlockUseCase(blockRepository);
    }
}
