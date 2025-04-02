package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.MainPage;
public class MainSteps {
    private final MainPage mainPage = new MainPage();

    public void verifyNewsHeaderVisible() {
        Allure.step("Проверка надписи News на главной странице");
        onView(isRoot()).perform(waitForElement(mainPage.getMainMenuImageButtonId(), 10000));
        mainPage.getNewsLogoView().check(matches(isDisplayed()));
    }

    public void verifyMissionButtonVisible() {
        Allure.step("Проверка кнопки \"Наша миссия\" на главной странице");
        mainPage.getOurMissionLogoView().check(matches(isDisplayed()));
    }

    public void clickMissionButton() {
        Allure.step("Нажатие на кнопку \"Наша миссия\" на главной странице");
        onView(isRoot()).perform(waitForElement(mainPage.getMainMenuImageButtonId(), 10000));
        mainPage.getOurMissionLogoView().perform(click());
    }

    public void performLogout() {
        Allure.step("Нажатие на кнопку Log Out");
        mainPage.getAuthorizationBlock().perform(click());
        mainPage.getLogOutButton().perform(click());
    }

    public void openMainMenu() {
        Allure.step("Нажатие на бургер-меню");
        onView(isRoot()).perform(waitForElement(mainPage.getMainMenuImageButtonId(), 10000));
        mainPage.getBurgerMenu().perform(click());
    }

    public void selectAboutInMenu() {
        Allure.step("Нажатие на About в бургер-меню");
        mainPage.getAboutBurgerMenu().perform(click());
    }

    public void selectNewsInMenu() {
        Allure.step("Нажатие на News в бургер-меню");
        mainPage.getNewsBurgerMenu().perform(click());
    }
}