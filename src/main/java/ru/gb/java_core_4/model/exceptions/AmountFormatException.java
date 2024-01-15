package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AmountFormatException extends NumberFormatException{
    private final String amount;


    public AmountFormatException(String amount) {
        this.amount = amount;
    }

    @Override
    public String getMessage() {
        return String.format("Заказ не сформирован. Количество товара \"%s\" указано в неверном формате."
                , amount);
    }

}
