package com.techie.microservice.inventory.repository;

import com.techie.microservice.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author HP
 **/
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode,Integer quantity);

    Optional<Inventory> findBySkuCode(String skuCode);
}
