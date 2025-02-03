package ru.iteco.fmhandroid.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.pageObject.AboutPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public MainPage mainPage;
    public AboutPage aboutPage;

    @Before
    public void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        mainPage = new MainPage();
    }

    @Test
    @Story("Открытие вкладки 'Политика конфиденциальности'")
    public void checkLinkPrivatePolicy() {
        mainPage.openAboutSection();
        aboutPage.openPrivacyPolicy();
    }

    @Test
    @Story("Открытие вкладки 'Пользовательское соглашение'")
    public void checkLinkTermsOfUse() {
        mainPage.openAboutSection();
        aboutPage.openTermsOfUse();
    }
}
