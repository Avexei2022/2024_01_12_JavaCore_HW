package ru.gb.java_core_4.model.orders;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderList {
    private final List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order){
        orderList.add(order);
    }
}
