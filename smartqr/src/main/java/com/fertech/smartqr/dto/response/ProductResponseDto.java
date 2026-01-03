package com.fertech.smartqr.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fertech.smartqr.model.enums.ProductStatusEnum;

public record ProductResponseDto(
    UUID id,
    Long enterpriseId,
    String name,
    String description,
    String usage,
    String howToUse,
    String imageUrl,
    ProductStatusEnum status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    
}
