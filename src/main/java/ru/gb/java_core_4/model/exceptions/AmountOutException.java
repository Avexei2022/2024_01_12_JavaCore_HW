package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class AmountOutException extends RuntimeException{

    private String productName;
    private int productAmount;
    private int orderAmount;

    public AmountOutException(String productName, int productAmount, int orderAmount) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.orderAmount = orderAmount;
    }


    @Override
    public String getMessage() {
        return String.format("Неверное количество товара \"%s\". Товара на складе %d единиц. В заказе %d единиц."
                , productName, productAmount, orderAmount);
    }
}
