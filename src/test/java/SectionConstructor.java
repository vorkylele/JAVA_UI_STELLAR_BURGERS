import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;

import static supportingdata.URLs.MAIN_PAGE;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class SectionConstructor {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
    }

    @Test
    @DisplayName("Переход разделу «Булки»")
    public void transitionToTheBunsSection() {
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        mainPage.logoOfBunsButtonVisible();
    }

    @Test
    @DisplayName("Переход разделу «Соусы»")
    public void transitionToTheSaucesSection() {
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.clickSaucesButton();
        mainPage.logoOfSaucesButtonVisible();
    }

    @Test
    @DisplayName("Переход разделу «Начинки»")
    public void transitionToTheFillingsSection() {
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.clickFillingsButton();
        mainPage.logoOfFillingsButtonVisible();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
