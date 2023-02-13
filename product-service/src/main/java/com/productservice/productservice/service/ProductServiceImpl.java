package com.productservice.productservice.service;

import com.productservice.productservice.dtos.ProductDTO;
import com.productservice.productservice.entity.Product;
import com.productservice.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
     ProductRepo productRepo;


    @Override
    public ProductDTO create(ProductDTO productDto) {
       Product productToPersist = new ProductDTO().toEntity(productDto);
        productToPersist=productRepo.save(productToPersist);
        return new ProductDTO().toDto(productToPersist);
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepo.findAll().parallelStream().map(x-> new ProductDTO().toDto(x)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id) {
        return new ProductDTO().toDto(productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found")));
    }

    @Override
    public void deleteById(Long id) {
        productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not FOund"));
        productRepo.deleteById(id);
    }
}
