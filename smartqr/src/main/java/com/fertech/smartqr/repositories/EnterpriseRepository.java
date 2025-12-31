package com.fertech.smartqr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fertech.smartqr.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{
    
}
