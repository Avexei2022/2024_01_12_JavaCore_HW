package ru.gb.java_core_4.model.orders;

import lombok.Data;
import ru.gb.java_core_4.model.products.Product;
import ru.gb.java_core_4.model.customers.Customer;

@Data
public class Order {
    private Customer customer;
    private Product product;
    int amount;

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }
}
