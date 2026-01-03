package com.fertech.smartqr.mappers;

import com.fertech.smartqr.dto.request.ProductCreateRequestDto;
import com.fertech.smartqr.dto.request.ProductUpdateRequestDto;
import com.fertech.smartqr.dto.response.ProductResponseDto;
import com.fertech.smartqr.mappers.generic.GenericMapper;
import com.fertech.smartqr.model.Product;

public class ProductMapper implements GenericMapper <
        Product, 
        ProductCreateRequestDto, 
        ProductUpdateRequestDto, 
        ProductResponseDto> {

    @Override
    public Product toEntity(ProductCreateRequestDto dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public ProductResponseDto toResponse(Product entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toResponse'");
    }

    @Override
    public void merge(Product entity, ProductUpdateRequestDto dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'merge'");
    }
    
}
