package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerRegException extends RuntimeException{
    private final String name;

    public CustomerRegException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return String.format("Покупателю \"%s\" отказано в регистрации. Введенные данные некорректны", name);
    }
}
