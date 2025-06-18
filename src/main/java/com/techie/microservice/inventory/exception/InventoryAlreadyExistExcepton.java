package com.techie.microservice.inventory.exception;

/**
 * @author HP
 **/
public class InventoryAlreadyExistExcepton extends RuntimeException {
    public InventoryAlreadyExistExcepton(String skuCode) {
        super("This Product is Already in Stock !, try to update it .");
    }
}
