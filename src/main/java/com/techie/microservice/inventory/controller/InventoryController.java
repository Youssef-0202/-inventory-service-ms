package com.techie.microservice.inventory.controller;

import com.techie.microservice.inventory.model.Inventory;
import com.techie.microservice.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author HP
 **/
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<?> createInventory(@RequestBody Inventory inventory){
        Inventory savedInventory = service.createInventory(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInventory.getId());
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode , @RequestParam Integer quantity){
        return service.isInStock(skuCode,quantity);
    }
}
