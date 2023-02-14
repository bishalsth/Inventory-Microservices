package com.example.inventoryservice.repo;

import com.example.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {


    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
