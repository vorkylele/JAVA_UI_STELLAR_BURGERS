import SupportingData.User;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;

import static SupportingData.URLs.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@DisplayName("Вход")
public class LoginTest {
    User user;

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
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("ОР: Перенаправление на главную страницу")
    public void loginFromMainPage() {

        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setNameField(user.getName());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        MainPage mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет")
    @Description("ОР: Перенаправление на главную страницу")
    public void loginFromPersonalAccount() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setNameField(user.getName());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        MainPage mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в форме регистрации")
    @Description("ОР: Перенаправление на главную страницу")
    public void logInFromRegistrationPage() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setNameField(user.getName());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        registerPage = open(REGISTER_PAGE, RegistrationPage.class);
        registerPage.clickLogInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage();
        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в форме регистрации в форме восстановления пароля перенаправляет на главную страницу")
    @Description("ОР: Перенаправление на главную страницу")
    public void logInFromForgotPasswordPage() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setNameField(user.getName());
        registerPage.setEmailField(user.getEmail());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        ForgotPasswordPage forgotPasswordPage = open(FORGOT_PASSWORD_PAGE, ForgotPasswordPage.class);
        forgotPasswordPage.clickLogInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage();
        mainPage.placeOrderButtonAvailable();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}