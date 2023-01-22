package com.vorkylele.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.vorkylele.api.generatingdata.GeneratingDataOfUser;
import com.vorkylele.utils.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.vorkylele.config.ConfigSingle.config;
import static com.vorkylele.config.EndPoints.LOGIN;

@DisplayName("Регистрация")
public class RegistrationTest extends BaseTest {

    @Override
    @Before
    @Description("Конфигурация перед началом выполнения теста")
    public void setUp() throws InterruptedException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        user = GeneratingDataOfUser.createNewUser();
    }

    @Test
    @DisplayName("Создание нового пользователя с валидными данными")
    public void successfulRegistration() {
        registrationPage
                .openRegistrationPage()
                .setNameField(user.getName())
                .setEmailField(user.getEmail())
                .setPasswordField(user.getPassword())
                .clickRegistrationButton();

        webdriver().shouldHave(url(config.getBaseUriProperties() + LOGIN));
    }

    @Override
    @After
    @Description("Конфигурация после окончания теста")
    public void deleteDataOfUser() {}
}