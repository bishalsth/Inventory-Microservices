package com.productservice.productservice.service;

import com.productservice.productservice.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO create(ProductDTO productDto);
     List<ProductDTO> getAll();
    ProductDTO getById(Long id);
    void deleteById(Long id);
}
