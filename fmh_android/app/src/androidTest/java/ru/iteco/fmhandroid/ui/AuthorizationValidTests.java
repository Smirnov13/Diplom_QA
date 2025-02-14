package ru.iteco.fmhandroid.ui;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.config.ConfigProperties;
import ru.iteco.fmhandroid.ui.pageObject.AuthPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationValidTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public AuthPage authPage;
    public Utils utils;
    @Before
    void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        authPage = new AuthPage();
        utils = new Utils();

        utils.downloadApp();
    }

    @Test
    @Story("Негативная авторизация с неверными данными")
    @Description("Тест проверяет, что пользователь не может авторизоваться с неверными учетными данными")
    public void authorizationInvalidTest() {
        Allure.step("Заполнение неверных данных для авторизации");
        authPage.fillCreds("invalidUser", "invalidPassword");

        Allure.step("Нажатие кнопки авторизации");
        authPage.tapLoginButton();

        Allure.step("Проверка отображения ошибки авторизации");
        authPage.verifyLoginFailure();
    }

    @Test
    @Story("Авторизация с пустыми полями")
    @Description("Тест проверяет, что пользователь не может авторизоваться с пустыми полями логина и пароля")
    public void authorizationEmptyFieldsTest() {
        Allure.step("Заполнение пустых данных для авторизации");
        authPage.fillCreds("", "");

        Allure.step("Нажатие кнопки авторизации");
        authPage.tapLoginButton();

        Allure.step("Проверка отображения ошибки при пустых полях");
        authPage.verifyLoginFailure();
    }

}
