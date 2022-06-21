package pages.selenide;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

/**
 * Класс для работы с фильтром Яндекс.Маркета
 */
public class YandexMarketFilterPage extends BasePage {

    /**
     * Метод для выбора производителя товара
     * @param manufacturer наименование производителя
     * @return страницу фильтра Яндекс.Маркета
     */
    @Step("Выберем производителя: {manufacturer}")
    public YandexMarketFilterPage selectManufacturer(String manufacturer) {
        $x("//fieldset[contains(*, 'Производитель')]/descendant::*[text()='Показать всё']").should(Condition.visible).click();
        $x("//fieldset[contains(*, 'Производитель')]/descendant::input[@type='text']").should(Condition.visible).setValue(manufacturer);
        $x("//span[text()='" + manufacturer + "']").should(Condition.visible).click();
        return this;
    }

    /**
     * Метод проверяет, что все найденные товары имеют производителя manufacturer.
     * Так же метод проверяет, что после первого нажатия отображается 48 позиций товара.
     * @param manufacturer наименование производителя
     * @param expectedCount ожидаемое количество позиций товара после первого нажатия "Показать ещё"
     * @return страницу фильтра Яндекс.Маркета
     */
    @Step("Проверим, что все позиции имеют производителя {manufacturer}")
    public YandexMarketFilterPage checkManufacturer(String manufacturer, int expectedCount) {
        int numberPage = 0;
        while (true) {
            if (numberPage == 1) {
                $$x("//article[@data-autotest-id='product-snippet']").shouldBe(CollectionCondition.size(expectedCount));
            }
            $$x("//article[@data-autotest-id='product-snippet']")
                            .should(CollectionCondition.allMatch("Проверим, что все позиции имеют производителя " + manufacturer,
                                    x->x.getText().toLowerCase().contains(manufacturer.toLowerCase())));
            if ($x("//*[@data-apiary-widget-id='/content/pager' or @data-zone-name='SearchPager']").shouldBe(Condition.enabled).getText().contains("Показать ещё")) {
                $x("//*[@data-apiary-widget-id='/content/pager' or @data-zone-name='SearchPager']/descendant::button[contains(., 'Показать ещё')]").click();
                ++numberPage;
            }
            else
                break;
        }
        return this;
    }
}
