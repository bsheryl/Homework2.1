package tests.selenide;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.selenide.YandexMainPage;
import pages.selenide.YandexMarketMainPage;

import static com.codeborne.selenide.Selenide.open;

public class Tests extends BaseTests {

    /**
     * Метод для тестирования Яндекс.Маркета через PO в Selenide.
     * Делаем серию переходов Яндекс - Яндекс.Маркет - Электроника - Смартфоны.
     * Далее выбираем производителя и проверяем, что все позиции имеют выбранного производителя.
     * Так же после первого нажатия на кнопку "Показать ещё" проверяем, что отображается expectedCount элементов
     * @param service наименование сервиса Яндекса
     * @param category наименование категории товара
     * @param type наименование типа товара
     * @param manufacturer наименование производителя
     * @param expectedCount ожидаемое количество товара после нажатия "Показать ещё"
     */
    @Feature("Тестирование Яндекс.Маркета")
    @DisplayName("Тестирование Яндекс.Маркета через PO в Selenide")
    @ParameterizedTest
    @MethodSource("helpers.DataProvider#provideNameManufacturer")
    public void testYandexMarketPO(String service, String category, String type, String manufacturer, int expectedCount) {
        open("https://yandex.ru/", YandexMainPage.class)
                .goToYandexService(service, YandexMarketMainPage.class)
                .goToCategory(category)
                .goToType(type)
                .selectManufacturer(manufacturer)
                .checkManufacturer(manufacturer, expectedCount)
        ;
    }
}
