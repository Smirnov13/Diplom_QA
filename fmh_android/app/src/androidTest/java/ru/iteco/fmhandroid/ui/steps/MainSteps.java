package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.MainPage;

public class MainSteps {

    private final MainPage mainPage = new MainPage();

    public void openNewsSection() {
        Allure.step("Открытие раздела 'Новости'");
        mainPage.getMenuButton().check(matches(isDisplayed()));
        mainPage.getMenuButton().perform(click());
        mainPage.getNewsSectionButton().check(matches(isDisplayed()));
        mainPage.getNewsSectionButton().perform(click());
        mainPage.getNewsPage().check(matches(isDisplayed()));
    }


    public void openAboutSection() {
        Allure.step("Открытие раздела 'О проекте'");
        mainPage.getMenuButton().check(matches(isDisplayed()));
        mainPage.getMenuButton().perform(click());
        mainPage.getAboutSectionButton().check(matches(isDisplayed()));
        mainPage.getAboutSectionButton().perform(click());
        mainPage.getAboutPageVersion().check(matches(isDisplayed()));
    }

    public void openMissionSection() {
        Allure.step("Открытие раздела 'Наша миссия'");
        mainPage.getMissionIconButton().check(matches(isDisplayed()));
        mainPage.getMissionIconButton().perform(click());
        mainPage.getMissionPageTitle().check(matches(isDisplayed()));
    }

    public boolean isNewsSectionDisplayed() {
        Allure.step("Проверка отображения раздела 'Новости'");
        return isElementDisplayed(mainPage.getNewsPage());
    }

    public boolean isAboutSectionDisplayed() {
        Allure.step("Проверка отображения раздела 'О проекте'");
        return isElementDisplayed(mainPage.getAboutPageVersion());
    }


    public boolean isMissionSectionDisplayed() {
        Allure.step("Проверка отображения раздела 'Наша миссия'");
        return isElementDisplayed(mainPage.getMissionPageTitle());
    }

    public boolean isError() {
        Allure.step("Проверка отображения ошибки");
        return isElementDisplayed(mainPage.getErrorTitle());
    }

    private boolean isElementDisplayed(ViewInteraction element) {
        try {
            element.check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
