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
import ru.iteco.fmhandroid.ui.pageObject.AuthPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class MainPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public MainPage mainPage;
    public AuthPage authPage;
    public Utils utils;

    @Before
    void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        mainPage = new MainPage();
        utils = new Utils();
        authPage = new AuthPage();

        utils.downloadApp();
        authPage.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authPage.tapLoginButton();
    }

    @Test
    @Story("Открытие раздела 'Новости'")
    @DisplayName("Пользователь открывает раздел 'Новости'")
    @Description("Проверяем, что после открытия раздела 'Новости' он действительно отображается")
    public void openNewsSection() {
        Allure.step("Открытие раздела 'Новости'");
        mainPage.openNewsSection();
        assertTrue("Раздел 'Новости' не открыт", mainPage.isNewsSectionDisplayed());
    }

    @Test
    @Story("Открытие раздела 'О проекте'")
    @DisplayName("Пользователь открывает раздел 'О проекте'")
    @Description("Проверяем, что после открытия раздела 'О проекте' он действительно отображается")
    public void openAboutSection() {
        Allure.step("Открытие раздела 'О проекте'");
        mainPage.openAboutSection();
        assertTrue("Раздел 'О проекте' не открыт", mainPage.isAboutSectionDisplayed());
    }

    @Test
    @Story("Открытие раздела 'Наша миссия'")
    @DisplayName("Пользователь открывает раздел 'Наша миссия'")
    @Description("Проверяем, что после открытия раздела 'Наша миссия' он действительно отображается")
    public void openMissionSection() {
        Allure.step("Открытие раздела 'Наша миссия'");
        mainPage.openMissionSection();
        assertTrue("Раздел 'Наша миссия' не открыт", mainPage.isMissionSectionDisplayed());
    }

    @Test
    @Story("Негативный тест - ввод неверных данных при авторизации")
    @DisplayName("Попытка входа с неверными данными")
    @Description("Проверяем, что при вводе неверных данных появляется сообщение об ошибке")
    public void loginWithInvalidCreds() {
        Allure.step("Ввод неверных учетных данных");
        authPage.fillCreds("wrongUser", "wrongPass");
        authPage.tapLoginButton();
        assertTrue("Ошибка не отображается", mainPage.isError());
    }


}
