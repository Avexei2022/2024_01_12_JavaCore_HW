package ru.gb.java_core_4.model.customers;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegisteredCustomersList {
    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

}
