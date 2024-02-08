package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase {

    @Test
    void canRegisterUser(String username) {
        var email = String.format("%s@localhost", username);
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        // заполняем форму создания и отправляем (браузер)
        // получаем\ждём почту (MailHelper)
        // извлекаем  ссылку из письма
        // проходим по ссылке и завершаем регистарцию (браузер)
        // проверяем что пользователь может залогинеться (HttpSessionHelper)

    }

}
