package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class MainPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    public MainPage mainPage;

    @Before
    void init(){
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
        mainPage = new MainPage();
    }

    @Test
    @Story("Открытие раздела 'Новости' через главное меню")
    public void openNewsSection() {
        mainPage.openNewsSection();
    }

    @Test
    @Story("Открытие раздела 'О проекте' через главное меню")
    public void openAboutSection() {
        mainPage.openAboutSection();
    }

    @Test
    @Story("Открытие раздела 'Наша миссия' через главное меню")
    public void openMissionSection() {
        mainPage.openMissionSection();
    }

}
