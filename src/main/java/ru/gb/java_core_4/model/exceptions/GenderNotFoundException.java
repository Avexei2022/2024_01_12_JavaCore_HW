package ru.gb.java_core_4.model.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GenderNotFoundException extends IllegalArgumentException{

    private final String gender;
    private final String name;

    public GenderNotFoundException(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String getMessage() {
        return String.format("Покупателю \"%s\" отказано в регистрации. Гендер \"%s\" не существует.", name, gender);
    }
}
