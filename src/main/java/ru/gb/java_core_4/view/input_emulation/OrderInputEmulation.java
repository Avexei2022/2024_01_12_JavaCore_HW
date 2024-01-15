package ru.gb.java_core_4.view.input_emulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OrderInputEmulation {

    public ArrayList<List<String>> inputOrderList(){
        return new ArrayList<>(Stream.of(
                        (Stream.of("Иванов", "Стол", "2").toList()),
                        (Stream.of("Петров", "Стул", "8").toList()),
                        (Stream.of("Сидорова", "Кресло", "3").toList()),
                        (Stream.of("Сидорова", "Трюмо", "4").toList()),
                        (Stream.of("Семенова", "Шкаф", "-1").toList()),
                        (Stream.of("Иванов", "Диван", "400").toList()),
                        (Stream.of("Иванова", "Диван", "3")).toList())
                .toList());
    }
}
