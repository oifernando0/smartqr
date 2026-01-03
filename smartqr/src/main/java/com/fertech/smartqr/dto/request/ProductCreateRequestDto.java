package com.fertech.smartqr.dto.request;

import java.time.LocalDateTime;

import com.fertech.smartqr.model.enums.ProductStatusEnum;

public record ProductCreateRequestDto(
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
