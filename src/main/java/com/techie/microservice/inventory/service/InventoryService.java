package com.techie.microservice.inventory.service;

import com.techie.microservice.inventory.model.Inventory;
import com.techie.microservice.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HP
 **/
@Service
public class InventoryService {
    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<Inventory> getAllInventory(){
        return repository.findAll();
    }

    public Inventory createInventory(Inventory inventory){
        return repository.save(inventory);
    }

    public boolean isInStock(String skuCode,Integer quantity){
        return repository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }

    public List<Inventory> findAll() {
        return repository.findAll();
    }
}
