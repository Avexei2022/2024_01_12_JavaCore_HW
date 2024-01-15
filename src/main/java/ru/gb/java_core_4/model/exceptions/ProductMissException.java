package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductMissException extends RuntimeException{
    private final String product;

    public ProductMissException(String product) {
        this.product = product;
    }

    @Override
    public String getMessage() {
        return String.format("товар \"%s\" в магазине отсутствует.", product);
    }
}
