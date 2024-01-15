package ru.gb.java_core_4;

import java.util.Arrays;

public class Shop {
/**
 * Вызвать метод совершения покупки несколько раз таким образом,
 * чтобы заполнить массив покупок возвращаемыми значениями.
 * Обработать исключения следующим образом (в заданном порядке):
 * */
    private static class Customer {
        String name;
        int age;
        String phone;

        public Customer(String name, int age, String phone) {
            this.name = name;
            this.age = age;
            this.phone = phone;
            }

        @Override
        public String toString() {
            return "Покупатель: имя = '" + name + '\'' +
                    ", возраст = " + age + ", телефон = '" + phone + "'";
            }
        }

        private static class Item {
            String name;
            int cost;

            public Item(String name, int cost) {
                this.name = name;
                this.cost = cost;
            }

        @Override
        public String toString() {
                return "Товар: наименование = '" + name + "', цена = " + cost + "'";
            }
        }

        private static class Order {
            Customer customer;
            Item item;
            int amount;

            public Order(Customer customer, Item item, int amount) {
                this.customer = customer;
                this.item = item;
                this.amount = amount;
            }

            @Override
            public String toString() {
                return "Заказ: покупатель = " + customer +
                        ", товар = " + item + ", количество = " + amount + "\n";
            }
        }
        public static class CustomerException extends RuntimeException {
            public CustomerException(String message) {
                super(message);
            }
        }


        public static class ProductException extends RuntimeException {
            public ProductException(String message) {
                super(message);
            }
        }

        public static class AmountException extends RuntimeException {
            public AmountException(String message) {
                super(message);
            }
        }

        private final static Customer[] people = {
            new Customer("Иван Иванович", 20, "+1-222-333-44-55"),
            new Customer("Петр Петрович", 30, "+2-333-444-55-66"),
            };

        private final static Item[] items = {
            new Item("Мячь", 100),
            new Item("Стул", 1000),
            new Item("Стол", 10000),
            new Item("Автомобиль", 100000),
            new Item("Ракета", 10000000)
            };

        private static Order[] orders = new Order[5];

        private static boolean isInArray(Object[] arr, Object o) {
//            for (int i = 0; i < arr.length; i++)
//                if (arr[i].equals(o)) return true;
//            return false;
            return Arrays.stream(arr).anyMatch(i -> i == o);
        }

        public static Order buy(Customer who, Item what, int howMuch) {
            if (!isInArray(people, who))
                throw new CustomerException("Неизвестный покупатель: " + who);
            if (!isInArray(items, what))
                throw new ProductException("Неизвестный товар: " + what);
            if (howMuch < 0 || howMuch > 100)
                throw new AmountException("Неверное количество товара: " + howMuch);
            return new Order(who, what, howMuch);

        }

        public static void main(String[] args) {
            Object[][] try_order = {
                {people[0], items[0], 1}, //good
                {people[1], new Item("Цветы", 10), 1}, //no item
                {people[0], items[1], -1}, //bad amount -1
                {people[1], items[2], 150}, //bad amount >100
                {new Customer("Федор Федорович", 40, "+3-444-555-66-77"), items[3], 1}, //no customer
                };

            int capacity = 0;
            int i = 0;

            while (capacity != orders.length - 1 || i != try_order.length) {
                try {
                    System.out.println("\nЗаказ №" + (i+1) + " " + Arrays.toString(Arrays.stream(try_order[i]).toArray()));
                    orders[capacity] = buy((Customer) try_order[i][0], (Item) try_order[i][1], (int) try_order[i][2]);
                    System.out.println("Заказ №" + (i+1) +" принят в обработку.");
                    capacity++;
                } catch (ProductException | AmountException e) {
                    System.out.println(e.getMessage() + "\nОтказано в заказе.\n" + Arrays.toString(e.getStackTrace()));;
                } catch (CustomerException e) {
                    throw new RuntimeException(e);
                } finally {
                    ++i;
                }
                System.out.println("\nПринято заказов: " + capacity + "\n");
            }
        }
}
