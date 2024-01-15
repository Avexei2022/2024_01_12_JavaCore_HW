package ru.gb.java_core_4.model.products;

import lombok.Data;

@Data
public class Product {
    private String name;
    private int cost;
    private  int amount;

    public Product(String name, int cost, int amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }
}
