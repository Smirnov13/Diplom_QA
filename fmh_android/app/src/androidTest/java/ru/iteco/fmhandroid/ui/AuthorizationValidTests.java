package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.config.ConfigProperties;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationValidTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public AuthSteps authSteps;
    public Utils utils;
    @Before
    void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        authSteps = new AuthSteps();
        utils = new Utils();

        utils.downloadApp();

        try {
            authSteps.openAuthPage();
        } catch (Exception e) {
            authSteps.logout();
            authSteps.openAuthPage();
        }
    }

    @Test
    @Story("Авторизация зарегистрированным пользователем")
    @Description("Тест проверяет, что пользователь может авторизоваться с валидными логином и паролем")
    public void logInRegisteredUser() {
        authSteps.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authSteps.tapLoginButton();
        authSteps.verifyLoginSuccess();
    }

    @Test
    @Story("Выход из учётной записи")
    @Description("Тест проверяет, что пользователь может авторизоваться с валидными логином и паролем, а затем выйти их профиля")
    public void logOutRegisteredUser() {
        authSteps.fillCreds("invalidUser", "invalidPassword");
        authSteps.tapLoginButton();
        authSteps.logout();
    }

    @Test
    @Story("Негативная авторизация с неверными данными")
    @Description("Тест проверяет, что пользователь не может авторизоваться с неверными учетными данными")
    public void authorizationInvalidTest() {
        authSteps.fillCreds("invalidUser", "invalidPassword");
        authSteps.tapLoginButton();
        authSteps.verifyLoginFailure();
    }

    @Test
    @Story("Авторизация с пустыми полями")
    @Description("Тест проверяет, что пользователь не может авторизоваться с пустыми полями логина и пароля")
    public void authorizationEmptyFieldsTest() {
        authSteps.fillCreds("", "");
        authSteps.tapLoginButton();
        authSteps.verifyLoginFailure();
    }

}
