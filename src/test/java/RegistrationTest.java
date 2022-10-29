import io.restassured.response.ValidatableResponse;
import supportingdata.User;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.RegistrationPage;
import supportingdata.UserSteps;

import static supportingdata.URLs.LOGIN_PAGE;
import static supportingdata.URLs.REGISTER_PAGE;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@DisplayName("Регистрация")
public class RegistrationTest {
    User user;
    private UserSteps userSteps = new UserSteps();
    ValidatableResponse response;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
        user = User.createNewUser();
    }

    @Test
    @DisplayName("Создание нового пользователя с валидными данными")
    public void successfulRegistration() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setEmailField(user.getEmail());
        registerPage.setNameField(user.getName());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        webdriver().shouldHave(url(LOGIN_PAGE));
}

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
        response = userSteps.loginUser(user);
        String token = User.getAccessToken(response);
        user.setAccessToken(token);
        userSteps.deleteUser(user);
    }
}