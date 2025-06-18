package com.techie.microservice.inventory.controller;

import com.techie.microservice.inventory.exception.InsufficientInventoryException;
import com.techie.microservice.inventory.exception.InventoryAlreadyExistExcepton;
import com.techie.microservice.inventory.exception.InventoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author HP
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    record ErrorResponse(String error, String message, int status) {}


    @ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInventoryNotFound(InventoryNotFoundException ex){
        ErrorResponse error = new ErrorResponse("Inventory Not Found" ,ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InventoryAlreadyExistExcepton.class)
    public ResponseEntity<ErrorResponse> handleInventoryAlreadyExist(InventoryAlreadyExistExcepton ex){
        ErrorResponse error = new ErrorResponse("Inventory Already Exists" ,ex.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(InsufficientInventoryException.class)
    public ResponseEntity<String> handleInsufficientInventory(InsufficientInventoryException ex) {
        ErrorResponse error = new ErrorResponse(
                "Insufficient Inventory",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.message);
    }
}
