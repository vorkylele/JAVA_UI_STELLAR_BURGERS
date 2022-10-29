package supportingdata;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.Data;

@Data
public class User {
    private String email;
    private String password;
    private String name;
    public String accessToken;

    public User() {
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    @Step("Создание пользователя")
    public static User createNewUser() {
        return new User(Faker.instance().internet().emailAddress(),
                Faker.instance().internet().password(),
                Faker.instance().name().firstName());
    }
    public static String getAccessToken(ValidatableResponse validatableResponse) {
        return validatableResponse.extract().path("accessToken").toString().substring(7);
    }
}
