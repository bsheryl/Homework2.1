package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Класс для предоставления данных
 */
public class DataProvider {

    /**
     * Метод предоставляет:
     *  используемый сервис Яндекса;
     *  категория товара на Яндекс.Маркете;
     *  тип товара на Яндекс.Маркете;
     *  наименование производителя, по которому необходимо делать выборку
     *  ожидаемое количество позиций товара после первого нажатия "Показать ещё"
     * @return аргументы для тестирования
     */
    public static Stream<Arguments> provideNameManufacturer() {
        return Stream.of(
            Arguments.of("Маркет", "Электроника", "Смартфоны", "Apple", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "Google", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "HONOR", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "HUAWEI", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "Nokia", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "OnePlus", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "OPPO", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "realme", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "Samsung", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "vivo", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "Xiaomi", 48),
            Arguments.of("Маркет", "Электроника", "Смартфоны", "ZTE", 48)
        );
    }
}
