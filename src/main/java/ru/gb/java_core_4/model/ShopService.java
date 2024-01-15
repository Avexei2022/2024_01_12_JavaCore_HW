package ru.gb.java_core_4.model;

import lombok.Data;
import lombok.Getter;
import ru.gb.java_core_4.model.customers.Customer;
import ru.gb.java_core_4.model.customers.RegisteredCustomersList;
import ru.gb.java_core_4.model.exceptions.*;
import ru.gb.java_core_4.model.orders.Order;
import ru.gb.java_core_4.model.orders.OrderList;
import ru.gb.java_core_4.model.products.Product;
import ru.gb.java_core_4.model.products.ProductList;

import java.util.Arrays;

@Data
public class ShopService {

    private final RegisteredCustomersList customersList = new RegisteredCustomersList();
    private final ProductList productList = new ProductList();
    private final OrderList orderList = new OrderList();


    @Getter
    public enum Holiday {
        NEW_YEAR("01.01"), MARСH_8("08.03"), FEBRUARY_23("23.02");
        private final String holiday;

        Holiday(String holiday) {
            this.holiday = holiday;
        }
    }

    public String createProductList(String name, String s_cost, String s_amount)
            throws CostAmountFormatException, ProductRegException {
        int i_cost;
        int i_amount;
        try {
            i_cost = Integer.parseInt(s_cost);
        } catch (NumberFormatException e){
            throw new CostAmountFormatException(name, s_cost, s_amount);
        }
        try {
            i_amount = Integer.parseInt(s_amount);
        } catch (NumberFormatException e){
            throw new CostAmountFormatException(name, s_cost, s_amount);
        }
        try {
            Product product = new Product(name, i_cost, i_amount);
            productList.addProduct(product);
            return String.format("Новый товар \"%s\" успешно добавлен в список.", name);
        } catch (ProductRegException e){
            throw new ProductRegException(name, s_cost, s_amount);
        }
    }
    public String customerRegistration(String name, String s_age, String phone, String gender)
            throws CustomerRegException, GenderNotFoundException, AgeFormatException {
        int i_age;
        Customer.Gender g_gender;
        try {
            i_age = Integer.parseInt(s_age);
        } catch (NumberFormatException e){
            throw  new AgeFormatException(name, s_age);
        }
        try {
            g_gender = Customer.Gender.valueOf(gender.toUpperCase());
        } catch (IllegalArgumentException e){
            throw new GenderNotFoundException(name, gender);
        }
        try {
            Customer customer = new Customer(name, i_age, phone, g_gender);
            customersList.addCustomer(customer);
            return String.format("Новый покупатель \"%s\" успешно зарегистрирован.", name);
        } catch (CustomerRegException e){
            throw new CustomerRegException(name);
        }
    }

    public String createOrderList(String s_customer, String s_product, String s_amount, String today)
            throws AmountFormatException, CustomerMissException, ProductMissException, AmountOutException {
        Customer customer;
        Product product;
        int order_amount;
        try {
            order_amount = Integer.parseInt(s_amount);
        } catch (NumberFormatException e){
            throw new AmountFormatException(s_amount);
        }
        try {
            customer = customersList.getCustomerList().stream()
                    .filter(v -> v.getName().equalsIgnoreCase(s_customer)).findAny().orElseThrow();
        } catch (RuntimeException e){
            throw new CustomerMissException(s_customer);
        }

        try {
            product = productList.getProductList().stream()
                    .filter(c-> c.getName().equalsIgnoreCase(s_product)).findAny().orElseThrow();
        } catch (RuntimeException e){
            throw new ProductMissException(s_product);
        }
        int amount = product.getAmount();
        if (order_amount < 1 || order_amount > amount){
            throw new AmountOutException(s_product, amount, order_amount);
        }
        Order order = new Order(customer, product, order_amount);
        orderList.addOrder(order);
        Customer.Gender gender = customer.getGender();
        String customer_name = customer.getName();
        String congratulation = sendCongratulation(customer_name, gender, today);
        return String.format("%s\nЗаказ %s успешно сформирован.\nОбщее количество заказов - %d\n",
                congratulation, order, orderList.getOrderList().size());
    }

    public String printCustomerList() {
        return Arrays.toString(customersList.getCustomerList().stream().map(c -> c.toString() + "\n").toArray());
    }

    public String printProductList() {
        return Arrays.toString(productList.getProductList().stream().map(c -> c.toString() + "\n").toArray());
    }

    private String sendCongratulation(String name, Customer.Gender gender, String today){
        String string = "";
        boolean flag = false;
        if(Holiday.NEW_YEAR.getHoliday().equals(today)) {
            string = "Новым годом!";
            flag = true;
        }
        if(Holiday.MARСH_8.getHoliday().equals(today) && gender.equals(Customer.Gender.FEMALE)) {
            string = "8 марта!";
            flag = true;
        }
        if(Holiday.FEBRUARY_23.getHoliday().equals(today) && gender.equals(Customer.Gender.MALE)) {
            string = "23 февраля!";
            flag = true;
        }
        if(flag){
            return String.format("Уважаемый покупатель %s сердечно поздравляем Вас с %s\n", name, string);
        } else {
            return string;
        }
    }
    public String printCongratulation(String today) {
        String string = customersList.getCustomerList().stream()
                .map(v -> sendCongratulation(v.getName(), v.getGender(), today))
                .toList().toString();
        return string.substring(1, string.length() - 1).replace(",","");    }
}
