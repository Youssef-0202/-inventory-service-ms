package com.techie.microservice.inventory.exception;

/**
 * @author HP
 **/
public class InventoryNotFoundException extends RuntimeException{
   public InventoryNotFoundException(String skuCode){
       super("Product with skuCode: " + skuCode + " not found in Stock!");
   }
}
