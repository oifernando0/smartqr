package com.fertech.smartqr.dto.response;

import java.time.LocalDateTime;

public record EnterpriseResponseDto(
    Long id,
    String code,
    String name,
    LocalDateTime created_at
) {
    
}
