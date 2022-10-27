package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalAccount {
    static SelenideElement messageOfEditData = $(By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']"));
    SelenideElement exitButton = $(By.xpath("//button[text()='Выход']"));

    @Step("Клик по кнопке 'Выход'")
    public void clickExitButton() {
        exitButton.click();
    }

    @Step("Отображение текста 'В этом разделе вы можете изменить свои персональные данные'")
    public static void messageOfEditDataAvailable() {
        messageOfEditData.shouldBe(Condition.visible);
    }
}
