package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AgeFormatException extends NumberFormatException{

    private final String name;
    private final String age;


    public AgeFormatException(String name, String age) {
       this.name = name;
       this.age = age;
    }

    @Override
    public String getMessage() {
        return String.format("Покупателю \"%s\" отказано в регистрации. Возраст \"%s\" указан неверно.", name, age);
    }
}
