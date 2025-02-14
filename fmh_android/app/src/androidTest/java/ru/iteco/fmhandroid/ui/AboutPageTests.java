package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.config.ConfigProperties;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.AuthPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public MainPage mainPage;
    public AboutPage aboutPage;
    public AuthPage authPage;
    public Utils utils;
    @Before
    public void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        mainPage = new MainPage();
        aboutPage = new AboutPage();
        authPage = new AuthPage();
        utils = new Utils();

        utils.downloadApp();
        authPage.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authPage.tapLoginButton();
    }

    @Test
    @Story("Открытие вкладки 'Политика конфиденциальности'")
    @Description("Тест проверяет, что ссылка на Политику конфиденциальности открывается корректно")
    public void checkLinkPrivatePolicy() {
        Allure.step("Открытие раздела 'О приложении'");
        mainPage.openAboutSection();

        Allure.step("Переход по ссылке 'Политика конфиденциальности'");
        aboutPage.openPrivacyPolicy();

        Allure.step("Проверка, что открылся экран Политики конфиденциальности");
        aboutPage.verifyPrivacyPolicyOpened();
    }

    @Test
    @Story("Открытие вкладки 'Пользовательское соглашение'")
    @Description("Тест проверяет, что ссылка на Пользовательское соглашение открывается корректно")
    public void checkLinkTermsOfUse() {
        Allure.step("Открытие раздела 'О приложении'");
        mainPage.openAboutSection();

        Allure.step("Переход по ссылке 'Пользовательское соглашение'");
        aboutPage.openTermsOfUse();

        Allure.step("Проверка, что открылся экран Пользовательского соглашения");
        aboutPage.verifyTermsOfUseOpened();
    }

    @Test
    @Story("Неудачное открытие вкладки 'Политика конфиденциальности' при ошибке")
    @Description("Тест проверяет, что при ошибке не удается открыть 'Политику конфиденциальности'")
    public void checkLinkPrivatePolicyFailure() {
        Allure.step("Открытие раздела 'О приложении'");
        mainPage.openAboutSection();

        Allure.step("Попытка открыть 'Политику конфиденциальности' с ошибкой");
        aboutPage.openPrivacyPolicyWithError();

        Allure.step("Проверка, что появилась ошибка при открытии 'Политики конфиденциальности'");
        aboutPage.verifyErrorOnOpeningPrivacyPolicy();
    }

    @Test
    @Story("Неудачное открытие вкладки 'Пользовательское соглашение' при ошибке")
    @Description("Тест проверяет, что при ошибке не удается открыть 'Пользовательское соглашение'")
    public void checkLinkTermsOfUseFailure() {
        Allure.step("Открытие раздела 'О приложении'");
        mainPage.openAboutSection();

        Allure.step("Попытка открыть 'Пользовательское соглашение' с ошибкой");
        aboutPage.openTermsOfUseWithError();

        Allure.step("Проверка, что появилась ошибка при открытии 'Пользовательского соглашения'");
        aboutPage.verifyErrorOnOpeningTermsOfUse();
    }
}
