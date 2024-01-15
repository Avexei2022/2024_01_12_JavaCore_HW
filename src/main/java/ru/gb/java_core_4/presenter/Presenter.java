package ru.gb.java_core_4.presenter;

import lombok.Data;
import ru.gb.java_core_4.model.ShopService;
import ru.gb.java_core_4.model.exceptions.*;
import ru.gb.java_core_4.view.View;

@Data
public class Presenter {
    private final View view;
    private final ShopService shopService = new ShopService();

    public void customerRegistration(String name, String age, String phone, String gender){
        String info = "";
        try {
            info = shopService.customerRegistration(name, age, phone, gender);
        } catch (AgeFormatException | GenderNotFoundException | CustomerRegException e) {
            info = e.getMessage();
        }
        view.printAnswer(info);
    }

    public void printCustomerList() {
        String info = shopService.printCustomerList();
        view.printAnswer(info);
    }

    public void createProductList(String name, String cost, String amount) {
        String info = "";
        try {
            info = shopService.createProductList(name, cost, amount);
        } catch (CostAmountFormatException | ProductRegException e){
        info = e.getMessage();
        }
        view.printAnswer(info);
    }

    public void printProductList() {
        String info = shopService.printProductList();
        view.printAnswer(info);
    }

    public void createOrderList(String customer, String product, String amount, String today) {
        String info = "";
        try {
            info = shopService.createOrderList(customer, product, amount, today);
        } catch (AmountFormatException | ProductMissException
                | AmountOutException e){
            info = e.getMessage();
        } catch (CustomerMissException e){
            throw new CustomerMissException(e.getMessage());
        }
        view.printAnswer(info);
    }

    public void printCongratulation(String today) {
        String info = shopService.printCongratulation(today);
        view.printAnswer(info);
    }
}
