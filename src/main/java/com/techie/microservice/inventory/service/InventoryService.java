package com.techie.microservice.inventory.service;

import com.techie.microservice.inventory.exception.InsufficientInventoryException;
import com.techie.microservice.inventory.exception.InventoryAlreadyExistExcepton;
import com.techie.microservice.inventory.exception.InventoryNotFoundException;
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
        if(repository.findBySkuCode(inventory.getSkuCode()).isPresent()){
            throw new InventoryAlreadyExistExcepton(inventory.getSkuCode());
        }
        return repository.save(inventory);
    }

    public boolean isInStock(String skuCode,Integer quantity){
        return repository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }

    public List<Inventory> findAll() {
        return repository.findAll();
    }

    public Inventory findBySkuCode(String skuCode){
        return repository.findBySkuCode(skuCode)
                .orElseThrow(()-> new InventoryNotFoundException(skuCode));
    }

    public Inventory updateBySkuCode(String skuCode, Integer quantityDemande) {
        Inventory inventory = findBySkuCode(skuCode);
        if(inventory.getQuantity() >= quantityDemande){
            inventory.setQuantity(inventory.getQuantity() - quantityDemande);
            return repository.save(inventory);
        }else {
            throw new InsufficientInventoryException(skuCode, quantityDemande, inventory.getQuantity());
        }
    }
}
