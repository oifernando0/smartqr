package com.fertech.smartqr.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fertech.smartqr.dto.request.EnterpriseCreateRequestDto;
import com.fertech.smartqr.dto.request.EnterpriseUpdateRequestDto;
import com.fertech.smartqr.dto.response.EnterpriseResponseDto;
import com.fertech.smartqr.mappers.EnterpriseMapper;
import com.fertech.smartqr.model.Enterprise;
import com.fertech.smartqr.repositories.EnterpriseRepository;

@Service
public class EnterpriseService {
    
    private final EnterpriseRepository repo;
    private final EnterpriseMapper mapper;

    public EnterpriseService (EnterpriseRepository repo, EnterpriseMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional
    public EnterpriseResponseDto create (EnterpriseCreateRequestDto dto) {

        Enterprise enterprise = mapper.toEntity(dto);

        return mapper.toResponse(
            repo.save(enterprise)
        );
    }

    @Transactional
    public EnterpriseResponseDto update (Long id, EnterpriseUpdateRequestDto dto) {

        if (!repo.existsById(id)) {
            throw new RuntimeException("Entity not registred");
        }

        Enterprise entity = repo.findById(id).orElseThrow(
            () -> new RuntimeException("ENtidade não existe")
        );
        mapper.merge(entity, dto);

        return mapper.toResponse(
            repo.save(entity)
        );
    }

    @Transactional
    public void delete (Long id) {

        if (!repo.existsById(id)) {
            throw new RuntimeException("Entity not registred");
        }

        repo.deleteById(id);        
    }

    @Transactional(readOnly = true)
    public EnterpriseResponseDto read (Long id) {
        Enterprise entity = repo.findById(id).orElseThrow(
            () -> new RuntimeException("Entidade inexistente")
        );
        return mapper.toResponse(entity);
    }

}
