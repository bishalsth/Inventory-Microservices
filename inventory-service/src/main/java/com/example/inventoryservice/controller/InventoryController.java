package com.example.inventoryservice.controller;

import com.example.inventoryservice.dtos.InventoryResponse;
import com.example.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")

public class InventoryController {

@Autowired
  InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
    return inventoryService.isInStock(skuCode);
    }
}
