package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.List;

public class UserRegistrationTests extends TestBase {

    DeveloperMailUser user;

    /*
    public static List<UserData> randomUser() {
        var rnd = CommonFunctions.randomString(8);
        return List.of(new UserData()
                .withUsername(rnd)
                .withUserRealName(rnd)
                .withUserEmail(rnd + "@localhost")
                .withUserPassword("password"));
    }

    @ParameterizedTest
    @MethodSource("randomUser")
    public void canRegisterUser(UserData userData) {
        app.jamesApi().addUser(userData.userEmail(), userData.userPassword());
        app.user().createNewAccount(userData.username(), userData.userEmail());
        var messages = app.mail().receive(userData.userEmail(), userData.userPassword(), Duration.ofSeconds(10));
        var url = app.mail().extractedUrlFromEmail(messages);
        app.user().confirmRegistration(url, userData.userRealName(), userData.userPassword());
        app.http().login(userData.username(), userData.userPassword());
        Assertions.assertTrue(app.http().isLoggedIn());
    }

     */


    @Test
    public void canRegisterUser() {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

        app.user().createNewAccount(user.name(), email);

        var message = app.developerMail().receive(user, Duration.ofSeconds(10));
        var url = app.mail().extractedUrlFromEmail(message);

        app.user().confirmRegistration(url,"test2", password);

        app.http().login(user.name(), password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
    @AfterEach
    void deleteMailUser() {
        app.developerMail().deleteUser(user);
    }



}
