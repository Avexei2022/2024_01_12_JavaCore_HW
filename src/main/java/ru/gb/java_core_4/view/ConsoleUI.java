package ru.gb.java_core_4.view;

import lombok.Data;
import ru.gb.java_core_4.presenter.Presenter;
import ru.gb.java_core_4.view.input_emulation.CustomerInputEmulation;
import ru.gb.java_core_4.view.input_emulation.OrderInputEmulation;
import ru.gb.java_core_4.view.input_emulation.ProductInputEmulation;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConsoleUI implements View{
    private final Presenter presenter = new Presenter(this);;
    private final String today = "23.02";
    private String user_string = "";


    public void run() {
        System.out.println("\nИнтернет магазин мебели.\n");

        System.out.println("Администратор формирует перечень товаров в консоли (эмуляция ввода).");
        inputProductByAdmin();

        System.out.println("\nПеречень товаров в магазине:");
        printProductList();


        System.out.println("\nАдминистратор формирует список покупателей в консоли (эмуляция ввода).");
        inputCustomerByAdmin();

        System.out.println("\nСписок зарегистрированных покупателей:");
        printCustomerList();

        printCongratulation();

        System.out.println("\nПокупатели заказывают товар (эмуляция ввода).");
        inputOrderByCustomer();

        System.out.println("\nМагазин закрыт.\n");
    }

    private void inputProductByAdmin(){
        ArrayList<List<String>> productList = new ProductInputEmulation().inputProductList();
        productList.forEach(v -> {
            presenter.createProductList(v.get(0), v.get(1), v.get(2));
        } );
    }
    private void inputCustomerByAdmin(){
        ArrayList<List<String>> customerList = new CustomerInputEmulation().inputCustomerList();
        customerList.forEach(v -> {
            presenter.customerRegistration(v.get(0), v.get(1), v.get(2), v.get(3));
        } );
    }

    private void inputOrderByCustomer() {
        ArrayList<List<String>> orderList = new OrderInputEmulation().inputOrderList();
        orderList.forEach(v -> {
            presenter.createOrderList(v.get(0), v.get(1), v.get(2), today);
        } );
    }

    private void printProductList(){
        presenter.printProductList();
    }
    private void printCustomerList(){
        presenter.printCustomerList();
    }

    private void printCongratulation(){
        presenter.printCongratulation(today);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

}
