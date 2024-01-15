package ru.gb.java_core_4.view.input_emulation;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomerInputEmulation {
    public ArrayList<List<String>> inputCustomerList(){
        return new ArrayList<>(Stream.of(
                (Stream.of("Иванов", "25", "111-11-11", "male").toList()),
                        (Stream.of("Петров", "30", "222-22-22", "male").toList()),
                        (Stream.of("Иванова", "21с", "333-33-33", "female").toList()),
                        (Stream.of("Петрова", "27", "444-44-44", "fmale").toList()),
                        (Stream.of("Сидорова", "31", "555-55-55", "female").toList()),
                (Stream.of("Семенова", "37", "666-66-66", "female")).toList())
                .toList());
    }
}
