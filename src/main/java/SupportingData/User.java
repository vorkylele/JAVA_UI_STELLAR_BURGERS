package SupportingData;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;
    private String password;
    private String name;

    @Step("Создание пользователя")
    public static User createNewUser() {
        return new User(Faker.instance().internet().emailAddress(),
                Faker.instance().internet().password(),
                Faker.instance().name().firstName());
    }
}
