package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.UserData;

import java.util.List;

public class UserRegistrationTests extends TestBase {

    public static List<UserData> randomUser() {
        var rnd = CommonFunctions.randomString(8);
        return List.of(new UserData()
                .withUsername(rnd)
                .withUserEmail(rnd + "@localhost")
                .withUserPassword("password"));
    }

    @ParameterizedTest
    @MethodSource("randomUser")
    public void canRegisterUser(UserData userData) {
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        //app.jamesCli().addUser(userData.userEmail(), userData.userPassword());

        // заполняем форму создания и отправляем (браузер)
        app.user().createNewAccount(userData.username(), userData.userEmail());
        Assertions.assertTrue(app.http().isLoggedIn());
        // получаем/ждём почту (MailHelper)

        // извлекаем  ссылку из письма
        // проходим по ссылке и завершаем регистарцию (браузер)
        // проверяем что пользователь может залогинеться (HttpSessionHelper)

    }

}
