import supportingdata.User;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.RegistrationPage;

import static supportingdata.URLs.REGISTER_PAGE;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@DisplayName("Тестирование некорректного пароля")
@RunWith(Parameterized.class)
public class PasswordTest {
    private final String pass;
    private final boolean expected;
    User user;

    public PasswordTest(String pass, boolean expected) {
        this.pass = pass;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Проверяемый пароль: {0}, отображение ошибки: {1}")
    public static Object[][] testPassword() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(0), false},
                {RandomStringUtils.randomAlphabetic(1), true},
                {RandomStringUtils.randomAlphabetic(5), true},
                {RandomStringUtils.randomAlphabetic(6), false}};
    }

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
    @DisplayName("Тестирование поля 'Пароль'")
    @Description("При регистрации с коротким паролем, выводится сообщение 'Некорректный пароль'")
    public void registrationWithShortPasswordTest() {
        RegistrationPage registrationPage = open(REGISTER_PAGE, RegistrationPage.class);

        registrationPage.setNameField(user.getName());
        registrationPage.setEmailField(user.getEmail());
        registrationPage.setPasswordField(pass);
        registrationPage.clickRegistrationButton();

        Boolean actual = registrationPage.errorMessageOfPassword.exists();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}

