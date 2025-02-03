package ru.iteco.fmhandroid.ui;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.config.ConfigProperties;
import ru.iteco.fmhandroid.ui.pageObject.AuthPage;

@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationValidTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public AuthPage authPage;
    @Before
    void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        authPage = new AuthPage();
    }

    @Test
    @Story("Успешная авторизация")
    public void authorizationValidTest() {
        authPage.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authPage.tapLoginButton();
        authPage.verifyLoginSuccess();
    }

}
