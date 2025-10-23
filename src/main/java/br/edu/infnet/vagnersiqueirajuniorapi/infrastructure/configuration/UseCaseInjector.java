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
    public CreateBlockUseCase  createBlockUseCase(ICondominiumRepository condominiumRepository, IBlockRepository blockRepository) {
        return new CreateBlockUseCase(condominiumRepository, blockRepository);
    }
}
