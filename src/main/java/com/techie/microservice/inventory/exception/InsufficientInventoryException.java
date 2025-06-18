package com.techie.microservice.inventory.exception;

/**
 * @author HP
 **/
public class InsufficientInventoryException extends RuntimeException{
    public InsufficientInventoryException(String skuCode, int requested, int available) {
        super("Stock insuffisant pour le produit '" + skuCode + "'. Quantité demandée : " + requested + ", disponible : " + available);
    }
}
