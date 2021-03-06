package com.example.bibliotecareactiva.application.useCase.useCaseCommandInterface;

import com.example.bibliotecareactiva.domain.dto.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveResource {
    Mono<ResourceDTO> saveResource(ResourceDTO resourceDTO);
}
