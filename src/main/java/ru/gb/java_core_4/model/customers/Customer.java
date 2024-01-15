package ru.gb.java_core_4.model.customers;

import lombok.Data;
import lombok.Getter;

@Data
public class Customer {

    @Getter
    public enum Gender {MALE, FEMALE};
    private String name;
    private int age;
    private String phone;
    private Gender gender;

    public Customer(String name, int age, String phone, Gender gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }
}
