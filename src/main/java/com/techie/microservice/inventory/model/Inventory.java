package com.techie.microservice.inventory.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author HP
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_inventory")
@RequiredArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private  Integer quantity;

}
