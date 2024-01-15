package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerMissException extends RuntimeException{
    private final String name;

    public CustomerMissException(String name) {
        this.name = name;
    }

    @Override
    public String getMessage() {
        return String.format("Покупатель \"%s\" не зарегистрирован.", name);
    }
}
