package tests.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import custom.allure.selenide.CustomAllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Класс для настроек по умолчанию
 */
public class BaseTests {

    protected static WebDriver driver;

    /**
     * Метод выполняет скриншоты каждого действия
     */
    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide().screenshots(true).savePageSource(true));
    }

    /**
     * Метод выполняет настройки браузера
     */
    @BeforeEach
    public void option() {
        Configuration.timeout = 10000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        driver = new ChromeDriver(options);
        setWebDriver(driver);
    }

    /**
     * Метод закрывает окно браузера по завершению теста
     */
    @AfterEach
    public void close() {
        driver.quit();
    }
}
