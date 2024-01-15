package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductRegException extends RuntimeException{
    private final String name;
    private final String cost;
    private final String amount;

    public ProductRegException(String name, String cost, String amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return String.format("Товар \"%s\" стоимостью %s в количестве %s не сформирован.", name, cost, amount);
    }
}
