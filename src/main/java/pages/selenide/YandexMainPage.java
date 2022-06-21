package pages.selenide;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * Класс для главной страницы Яндекса
 */
public class YandexMainPage extends BasePage {

    /**
     * Метод для перехода к сервису Яндекса
     * @param service наименование сервиса
     * @param typeNextPage наименование класса для работы с service
     * @return объект класса typeNextPage
     */
    @Step("Переходим в Яндекс.{service}")
    public <T extends BasePage> T goToYandexService(String service, Class<T> typeNextPage) {
        $x("//div[@class='services-new__item-title' and contains(text(), '" + service + "')]").click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }
}
