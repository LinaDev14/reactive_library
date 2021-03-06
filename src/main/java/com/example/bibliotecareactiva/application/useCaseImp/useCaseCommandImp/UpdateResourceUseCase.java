package com.example.bibliotecareactiva.application.useCaseImp.useCaseCommandImp;

import com.example.bibliotecareactiva.application.mappers.ResourceMapper;
import com.example.bibliotecareactiva.application.useCase.useCaseCommandInterface.UpdateResource;
import com.example.bibliotecareactiva.domain.dto.ResourceDTO;
import com.example.bibliotecareactiva.domain.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UpdateResourceUseCase implements UpdateResource {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Override
    public Mono<ResourceDTO> updateResource(ResourceDTO resourceDTO) {
        // validation
        Objects.requireNonNull(resourceDTO.getId(), "Id is required");
        return resourceRepository.save(resourceMapper.mapToCollection().apply(resourceDTO))
                .map(resourceMapper.mapToDTO());
    }
}
