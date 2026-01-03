package com.fertech.smartqr.mappers.generic;

public interface GenericMapper <E, D, U, R> {
    
    E toEntity (D dto);

    R toResponse (E entity);

    void merge (E entity, U dto);
    
}
