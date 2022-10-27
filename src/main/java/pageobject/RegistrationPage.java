package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement nameField = $(By.xpath("//fieldset[1]/div/div/input"));
    SelenideElement emailField = $(By.xpath("//fieldset[2]/div/div/input"));
    SelenideElement passwordField = $(By.xpath("//fieldset[3]/div/div/input"));
    SelenideElement registrationButton = $(By.xpath("//button[text()='Зарегистрироваться']"));
    SelenideElement logInButton = $(By.xpath("//a[text()='Войти']"));
    public SelenideElement errorMessageOfPassword = $(By.xpath("//p[text()='Некорректный пароль']"));

    @Step("Ввод значения в поле 'Имя'")
    public void setNameField(String name) {
        nameField.setValue(name);
    }

    @Step("Ввод значения в поле 'Email'")
    public void setEmailField(String email) {
        emailField.setValue(email);
    }

    @Step("Ввод значения в поле 'Пароль'")
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLogInButton() {
        logInButton.click();
    }
}
