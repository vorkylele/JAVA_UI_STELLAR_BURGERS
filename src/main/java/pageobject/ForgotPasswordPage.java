package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    SelenideElement logInButton = $(By.xpath(".//a[text()='Войти']"));
    @Step("Клик по кнопке 'Войти'")
    public void clickLogInButton() {
        logInButton.click();
    }
}
