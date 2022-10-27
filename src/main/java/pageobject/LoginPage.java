package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement emailField = $(By.cssSelector("input[name='name']"));
    SelenideElement passwordField = $(By.cssSelector("input[name='Пароль']"));
    SelenideElement logInButton = $(By.xpath("//button[text()='Войти']"));
    public SelenideElement logInLabel = $(By.xpath("//h2[text()='Вход']"));

    @Step("Ввод значения в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод значения в поле 'Пароль'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLogInButton() {
        logInButton.click();
    }
}
