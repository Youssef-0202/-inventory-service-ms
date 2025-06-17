package com.techie.microservice.inventory.repository;

import com.techie.microservice.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author HP
 **/
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode,Integer quantity);
}
