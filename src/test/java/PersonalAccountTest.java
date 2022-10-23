import SupportingData.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.LoginPage;
import pageObject.PersonalAccount;
import pageObject.RegistrationPage;
import pageObject.MainPage;


import static SupportingData.URLs.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@DisplayName("Переход по клику на «Личный кабинет»/Переход из личного кабинета в конструктор/Выход из аккаунта")
public class PersonalAccountTest {
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
    @DisplayName("Переход в «Личный кабинет» с авторизацией")
    public void transitionToThePersonalAccountWithAuthorization() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setEmailField(user.getEmail());
        registerPage.setNameField(user.getName());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        MainPage mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        mainPage.clickPersonalAccountButton();
        webdriver().shouldHave(url(USER_ACCOUNT_PAGE));
        PersonalAccount.messageOfEditDataAvailable();
    }

    @Test
    @DisplayName("Переход в «Личный кабинет» без авторизации")
    public void transitionToThePersonalAccountWithoutAuthorization() {
        MainPage mainPage = open(MAIN_PAGE, MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage();
        loginPage.logInLabel.shouldBe(Condition.exist);
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу, при клике на конструктор")
    public void transitionToTheMainPageWhenClickOnTheConstructor() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setEmailField(user.getEmail());
        registerPage.setNameField(user.getName());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        MainPage mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        mainPage.clickPersonalAccountButton();

        mainPage.clickConstructorButton();
        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу, при клике на Stellar Burger")
    public void transitionToTheMainPageWhenClickOnTheStellarBurger() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setEmailField(user.getEmail());
        registerPage.setNameField(user.getName());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        MainPage mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        mainPage.clickPersonalAccountButton();

        mainPage.clickLogoOfStellarButton();
        mainPage.placeOrderButtonAvailable();
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void exitFromPersonalAccount() {
        RegistrationPage registerPage = open(REGISTER_PAGE, RegistrationPage.class);

        registerPage.setEmailField(user.getEmail());
        registerPage.setNameField(user.getName());
        registerPage.setPasswordField(user.getPassword());
        registerPage.clickRegistrationButton();

        MainPage mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickLoginInAccountButton();

        LoginPage loginPage = new LoginPage();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPasswordField(user.getPassword());
        loginPage.clickLogInButton();

        mainPage.clickPersonalAccountButton();

        PersonalAccount personalAccount = new PersonalAccount();

        personalAccount.clickExitButton();
        loginPage.logInLabel.shouldBe(Condition.visible);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
