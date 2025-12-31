package com.fertech.smartqr.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fertech.smartqr.dto.request.EnterpriseCreateRequestDto;
import com.fertech.smartqr.dto.request.EnterpriseUpdateRequestDto;
import com.fertech.smartqr.dto.response.EnterpriseResponseDto;
import com.fertech.smartqr.services.EnterpriseService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    private final EnterpriseService service;

    public EnterpriseController (EnterpriseService service) {
        this.service = service;
    }
    
    @PostMapping("/create")
    public ResponseEntity<EnterpriseResponseDto> create (@Valid @RequestBody EnterpriseCreateRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EnterpriseResponseDto> update (@PathVariable Long id, @RequestBody EnterpriseUpdateRequestDto entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<EnterpriseResponseDto> read (@PathVariable Long id) {
        return ResponseEntity.ok(service.read(id));
    }
}
