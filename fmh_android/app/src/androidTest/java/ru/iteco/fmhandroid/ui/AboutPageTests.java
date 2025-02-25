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
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public MainSteps mainSteps;
    public AboutSteps aboutSteps;
    public AuthSteps authSteps;
    public Utils utils;
    @Before
    public void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        mainSteps = new MainSteps();
        aboutSteps = new AboutSteps();
        authSteps = new AuthSteps();
        utils = new Utils();

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
    @Story("Открытие вкладки 'Политика конфиденциальности'")
    @Description("Тест проверяет, что ссылка на Политику конфиденциальности открывается корректно")
    public void checkLinkPrivatePolicy() {
        mainSteps.openAboutSection();
        aboutSteps.openPrivacyPolicy();
        aboutSteps.verifyPrivacyPolicyOpened();
    }

    @Test
    @Story("Открытие вкладки 'Пользовательское соглашение'")
    @Description("Тест проверяет, что ссылка на Пользовательское соглашение открывается корректно")
    public void checkLinkTermsOfUse() {
        mainSteps.openAboutSection();
        aboutSteps.openTermsOfUse();
        aboutSteps.verifyTermsOfUseOpened();
    }

    @Test
    @Story("Неудачное открытие вкладки 'Политика конфиденциальности' при ошибке")
    @Description("Тест проверяет, что при ошибке не удается открыть 'Политику конфиденциальности'")
    public void checkLinkPrivatePolicyFailure() {
        mainSteps.openAboutSection();
        aboutSteps.openPrivacyPolicyWithError();
        aboutSteps.verifyErrorOnOpeningPrivacyPolicy();
    }

    @Test
    @Story("Неудачное открытие вкладки 'Пользовательское соглашение' при ошибке")
    @Description("Тест проверяет, что при ошибке не удается открыть 'Пользовательское соглашение'")
    public void checkLinkTermsOfUseFailure() {
        mainSteps.openAboutSection();
        aboutSteps.openTermsOfUseWithError();
        aboutSteps.verifyErrorOnOpeningTermsOfUse();
    }
}
