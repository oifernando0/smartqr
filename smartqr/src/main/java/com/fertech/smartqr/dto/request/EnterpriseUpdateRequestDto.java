package com.fertech.smartqr.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EnterpriseUpdateRequestDto(
    @NotNull @Size(max = 4) String code,
    @NotNull @Size(max = 20) String name,
    @NotNull LocalDateTime createdAt
) {}
