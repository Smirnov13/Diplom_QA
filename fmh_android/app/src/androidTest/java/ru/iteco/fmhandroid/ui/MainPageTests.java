package ru.iteco.fmhandroid.ui;

import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.config.ConfigProperties;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class MainPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public MainSteps mainSteps;
    public AuthSteps authSteps;
    public Utils utils;
    private final static String BAD_USERNAME = "bad_user";
    private final static String BAD_PASSWORD = "bad_pass";

    @Before
    void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        mainSteps = new MainSteps();
        utils = new Utils();
        authSteps = new AuthSteps();

        utils.downloadApp();

        try {
            authSteps.openAuthPage();
        } catch (Exception e) {
            authSteps.logout();
            authSteps.openAuthPage();
        }

        authSteps.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authSteps.tapLoginButton();
    }

    @Test
    @Story("Открытие раздела 'Новости'")
    @Description("Проверяем, что после открытия раздела 'Новости' он действительно отображается")
    public void openNewsSection() {
        mainSteps.openNewsSection();
        assertTrue("Раздел 'Новости' не открыт", mainSteps.isNewsSectionDisplayed());
    }

    @Test
    @Story("Открытие раздела 'О проекте'")
    @Description("Проверяем, что после открытия раздела 'О проекте' он действительно отображается")
    public void openAboutSection() {
        mainSteps.openAboutSection();
        assertTrue("Раздел 'О проекте' не открыт", mainSteps.isAboutSectionDisplayed());
    }

    @Test
    @Story("Открытие раздела 'Наша миссия'")
    @Description("Проверяем, что после открытия раздела 'Наша миссия' он действительно отображается")
    public void openMissionSection() {
        mainSteps.openMissionSection();
        assertTrue("Раздел 'Наша миссия' не открыт", mainSteps.isMissionSectionDisplayed());
    }

    @Test
    @Story("Негативный тест - ввод неверных данных при авторизации")
    @Description("Проверяем, что при вводе неверных данных появляется сообщение об ошибке")
    public void loginWithInvalidCreds() {
        authSteps.fillCreds(BAD_USERNAME, BAD_PASSWORD);
        authSteps.tapLoginButton();
        assertTrue("Ошибка не отображается", mainSteps.isError());
    }


}
