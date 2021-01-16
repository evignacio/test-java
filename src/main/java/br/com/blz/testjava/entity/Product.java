package br.com.blz.testjava.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Product {

    private Long sku;
    private String name;
    private Inventory inventory;
    private Boolean isMarketable;

    public Product(Long sku, String name, Inventory inventory) {
        this.sku = sku;
        this.name = name;
        this.inventory = inventory;
    }
}
