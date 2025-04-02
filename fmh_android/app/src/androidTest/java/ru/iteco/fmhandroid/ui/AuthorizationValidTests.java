package ru.iteco.fmhandroid.ui;

import static ru.iteco.fmhandroid.ui.utils.Constants.LOGIN_INCORRECT;
import static ru.iteco.fmhandroid.ui.utils.Constants.LOGIN;
import static ru.iteco.fmhandroid.ui.utils.Constants.PASSWORD;
import static ru.iteco.fmhandroid.ui.utils.Constants.PASSWORD_INCORRECT;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Авторизация")
public class AuthorizationValidTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private AuthSteps authSteps = new AuthSteps();
    private MainSteps mainSteps = new MainSteps();

    @Before
    public void setUp() {
        Utils.verifyAuthScreen(authSteps, mainSteps);
    }

    @Test
    @Story("Негативные сценарии авторизации")
    @Description("Попытка авторизации с пустыми полями должна показывать сообщение об ошибке")
    public void shouldShowErrorWhenLoginWithEmptyFields() {
        authSteps.clickSignInButton();
        authSteps.verifyEmptyFieldsErrorMessage(mActivityScenarioRule);
    }

    @Test
    @Story("Негативные сценарии авторизации")
    @Description("Попытка авторизации с невалидными данными должна показывать сообщение об ошибке")
    public void shouldShowErrorWhenLoginWithInvalidCredentials() {
        authSteps.enterLogin(LOGIN_INCORRECT);
        authSteps.enterPassword(PASSWORD_INCORRECT);
        authSteps.clickSignInButton();
        authSteps.verifyEmptyFieldsErrorMessage(mActivityScenarioRule);
    }

    @Test
    @Story("Негативные сценарии авторизации")
    @Description("Попытка авторизации с невалидным логином и пустым паролем должна показывать сообщение об ошибке")
    public void shouldShowErrorWhenLoginIsInvalidAndPasswordIsEmpty() {
        authSteps.enterLogin(LOGIN_INCORRECT);
        authSteps.clickSignInButton();
        authSteps.verifyEmptyFieldsErrorMessage(mActivityScenarioRule);
    }

    @Test
    @Story("Негативные сценарии авторизации")
    @Description("Попытка авторизации с невалидным паролем и пустым логином должна показывать сообщение об ошибке")
    public void shouldShowErrorWhenPasswordIsInvalidAndLoginIsEmpty() {
        authSteps.enterPassword(PASSWORD_INCORRECT);
        authSteps.clickSignInButton();
        authSteps.verifyEmptyFieldsErrorMessage(mActivityScenarioRule);
    }

    @Test
    @Story("Позитивные сценарии авторизации")
    @Description("Успешная авторизация с валидными данными и выход из системы")
    public void shouldSuccessfullyLoginAndLogoutWithValidCredentials() {
        authSteps.enterLogin(LOGIN);
        authSteps.enterPassword(PASSWORD);
        authSteps.clickSignInButton();

        mainSteps.verifyNewsHeaderVisible();
        mainSteps.verifyMissionButtonVisible();
        mainSteps.performLogout();

        authSteps.verifyAuthScreenElements();
    }

    @Test
    @Story("Позитивные сценарии авторизации")
    @Description("Успешная авторизация с валидными учетными данными")
    public void shouldSuccessfullyLoginWithValidCredentials() {
        authSteps.enterLogin(LOGIN);
        authSteps.enterPassword(PASSWORD);
        authSteps.clickSignInButton();

        mainSteps.verifyNewsHeaderVisible();
        mainSteps.verifyMissionButtonVisible();
    }
}