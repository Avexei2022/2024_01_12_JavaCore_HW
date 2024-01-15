package ru.gb.java_core_4.model.products;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductList {

    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }

}
