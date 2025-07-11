package com.techie.microservice.inventory.controller;

import com.techie.microservice.inventory.model.Inventory;
import com.techie.microservice.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/checkInStock")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode , @RequestParam Integer quantity){
        return service.isInStock(skuCode,quantity);
    }

    @PutMapping("/updateAfterOrder/{skuCode}/{quantityDemande}")
    public ResponseEntity<Inventory> updateBySkuCodeAfterOrder(@PathVariable String skuCode,@PathVariable Integer quantityDemande ){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateBySkuCodeAfterOrder(skuCode,quantityDemande));
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("")
    public ResponseEntity<Inventory> updateBySkuCode(@RequestBody Inventory inventory){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateBySkuCode(inventory));
    }

    // todo : look at isInStock method situation
}
