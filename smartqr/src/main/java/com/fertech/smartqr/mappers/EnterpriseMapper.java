package com.fertech.smartqr.mappers;

import java.time.LocalDateTime;

import com.fertech.smartqr.dto.request.EnterpriseCreateRequestDto;
import com.fertech.smartqr.dto.request.EnterpriseUpdateRequestDto;
import com.fertech.smartqr.dto.response.EnterpriseResponseDto;
import com.fertech.smartqr.model.Enterprise;

public final class EnterpriseMapper {
    
    public static Enterprise toEntity (EnterpriseCreateRequestDto dto) {
        return Enterprise.builder()
        .code(dto.code())
        .name(dto.name())
        .created_at(LocalDateTime.now())
        .build();
    }

    public static EnterpriseResponseDto toResponse (Enterprise entity) {
        return new EnterpriseResponseDto(
            entity.getId(),
            entity.getCode(),
            entity.getName(),
            entity.getCreated_at()
        );
    }

    public static void merge (Enterprise entity, EnterpriseUpdateRequestDto dto) {
        if (dto.code() != null) {
            entity.setCode(dto.code());
        }
        if (dto.name() != null) {
            entity.setName(dto.name());
        }
        if (dto.createdAt() != null) {
            entity.setCreated_at(dto.createdAt());
        }
    }
    
}
