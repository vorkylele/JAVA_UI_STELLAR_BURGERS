package supportingdata;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static supportingdata.URLs.*;

public class UserSteps extends RestClient{

    private String accessToken;

    @DisplayName("Создание пользователя")
    @Step("Создание пользователя")
    public static Response createUser(User body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(body)
                .when()
                .post(REGISTER);
    }

    @DisplayName("Авторизация пользователя")
    @Step("Авторизация пользователя")
    public static Response loginUser(User body) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(body)
                .when()
                .post(LOGIN);
    }

    @DisplayName("Получение access token пользователя")
    @Step("Получение access token пользователя")
    public static String getAccessToken(User body) {
        return loginUser(body)
                .then()
                .extract()
                .path("accessToken");
    }

    @DisplayName("Удаление пользователя")
    @Step("Удаление пользователя")
    public Response deleteUser(String accessToken) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .header("Authorization", accessToken)
                .when()
                .delete(USER);
    }
}
