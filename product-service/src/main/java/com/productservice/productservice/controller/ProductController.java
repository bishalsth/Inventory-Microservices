package com.productservice.productservice.controller;

import com.productservice.productservice.dtos.ProductDTO;
import com.productservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @PostMapping("/create")
    public ResponseEntity <?> createProduct(@RequestBody ProductDTO productDTO){
        productDTO = productService.create(productDTO);
        return ResponseEntity.ok("Success");

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        ProductDTO productDto = productService.getById(id);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ProductDTO>  productDtoList = productService.getAll();
        return ResponseEntity.ok(productDtoList);

    }
    
}
