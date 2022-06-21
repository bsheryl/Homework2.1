package pages.selenide;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс для работы с главной страницей Яндекс.Маркета
 */
public class YandexMarketMainPage extends BasePage {

    /**
     * Метод для перехода к категории товара
     * @param category категория товара
     * @return объек класса главной страницы Яндекс.Маркета
     */
    @Step("Переходим в раздел электроники")
    public YandexMarketMainPage goToCategory(String category) {
        $x("//div[@data-zone-name='category-link']/descendant::a[contains(., '" + category + "')]").click();
        return this;
    }

    /**
     * Метод для перехода к фильтру Яндекс.Маркета с типом товара
     * @param type тип товара
     * @return объект класса с фильтром Яндекс.Маркета
     */
    @Step("Переходим в подраздел Смартфоны")
    public YandexMarketFilterPage goToType(String type) {
        $x("//div[@data-zone-name='link']/a[text()='" + type + "']").click();
        return page(YandexMarketFilterPage.class);
    }
}
