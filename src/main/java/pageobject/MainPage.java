package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement loginInAccountButton = $(By.xpath("//button[text()='Войти в аккаунт']"));
    SelenideElement personalAccountButton = $(By.xpath("//p[text()='Личный Кабинет']"));
    SelenideElement logoOfStellarButton = $(By.xpath("//nav/div/a[@href='/']"));
    SelenideElement constructorButton = $(By.xpath("//p[text()='Конструктор']"));
    SelenideElement bunsButton = $(By.xpath("//span[text()='Булки']"));
    SelenideElement saucesButton = $(By.xpath("//span[text()='Соусы']"));
    SelenideElement fillingsButton = $(By.xpath("//span[text()='Начинки']"));
    SelenideElement placeOrderButton = $(By.xpath("//button[text()='Оформить заказ']"));
    SelenideElement logoOfBunsButton = $(By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']"));
    SelenideElement logoOfSaucesButton = $(By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']"));
    SelenideElement logoOfFillingsButton = $(By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']"));

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginInAccountButton() {
        loginInAccountButton.click();
    }

    @Step("Клик по кнопке 'Личный Кабинет'")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    @Step("Клик на логотип 'Stellar Burgers'")
    public void clickLogoOfStellarButton() {
        logoOfStellarButton.click();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("Клик по кнопке 'Булки'")
    public void clickBunsButton() {
        bunsButton.click();
    }

    @Step("Клик по кнопке 'Соусы'")
    public void clickSaucesButton() {
        saucesButton.click();
    }

    @Step("Клик по кнопке 'Начинки'")
    public void clickFillingsButton() {
        fillingsButton.click();
    }

    @Step("Отображение кнопки 'Оформить заказ'")
    public void placeOrderButtonAvailable() {
        placeOrderButton.shouldBe(Condition.visible);
    }

    @Step("Отображение лого 'Булки'")
    public void logoOfBunsButtonVisible() {
        logoOfBunsButton.shouldBe(Condition.visible);
    }

    @Step("Отображение лого 'Соусы'")
    public void logoOfSaucesButtonVisible() {
        logoOfSaucesButton.shouldBe(Condition.visible);
    }

    @Step("Отображение лого 'Начинки'")
    public void logoOfFillingsButtonVisible() {
        logoOfFillingsButton.shouldBe(Condition.visible);
    }
}
