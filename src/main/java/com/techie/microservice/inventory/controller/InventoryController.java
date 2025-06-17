package com.techie.microservice.inventory.controller;

import com.techie.microservice.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode , @RequestParam Integer quantity){
        return service.isInStock(skuCode,quantity);
    }
}
