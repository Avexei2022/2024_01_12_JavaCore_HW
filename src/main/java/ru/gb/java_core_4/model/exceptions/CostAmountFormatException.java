package ru.gb.java_core_4.model.exceptions;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CostAmountFormatException extends NumberFormatException{

    private final String name;
    private final String cost;
    private final String amount;


    public CostAmountFormatException(String name, String cost, String amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return String.format("Товар \"%s\" не сформирован. Цена \"%s\" или количество \"%s\" указаны неверно."
                , name, cost, amount);
    }
}
