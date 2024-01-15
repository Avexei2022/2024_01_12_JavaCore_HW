package ru.gb.java_core_4.view.input_emulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductInputEmulation {

    public ArrayList<List<String>> inputProductList(){
        return new ArrayList<>(Stream.of(
                        (Stream.of("Стол", "1000", "50").toList()),
                        (Stream.of("Стул", "400", "100").toList()),
                        (Stream.of("Тумбочка", "40c", "70").toList()),
                        (Stream.of("Трюмо", "2100", "20в").toList()),
                        (Stream.of("Кресло", "2000", "30").toList()),
                        (Stream.of("Шкаф", "3000", "25").toList()),
                        (Stream.of("Диван", "4000", "17")).toList())
                .toList());
    }

}
