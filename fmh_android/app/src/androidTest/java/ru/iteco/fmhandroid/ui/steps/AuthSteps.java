package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

public class AuthSteps {

    private final AuthPage authPage = new AuthPage();
    private final Utils utils = new Utils();

    public void fillCreds(String username, String password) {
        Allure.step("Заполнение полей логина: " + username + " и пароля");
        authPage.getUsernameInput().perform(replaceText(username), closeSoftKeyboard());
        authPage.getPasswordInput().perform(replaceText(password), closeSoftKeyboard());
    }

    public void tapLoginButton() {
        Allure.step("Клик по кнопке входа");
        authPage.getEnterButton().perform(click());
    }

    public void verifyLoginSuccess() {
        Allure.step("Проверка успешного входа");
        authPage.getLogoImage().check(matches(isDisplayed()));
    }

    public void verifyLoginFailure() {
        Allure.step("Проверка ошибки авторизации");
        authPage.getErrorText().check(matches(isDisplayed()));
    }

    public void logout() {
        Allure.step("Выход из учетной записи");
        authPage.getLogInButton().check(matches(isDisplayed()));
        authPage.getLogInButton().perform(click());
        onView(isRoot()).perform(utils.waitForElement(withText("Log out"), 5000));
        authPage.getLogOutButton().check(matches(isDisplayed()));
        authPage.getLogOutButton().perform(click());
        authPage.getAuthorization().check(matches(isDisplayed()));
    }
    public void openAuthPage() {
        Allure.step("Загрузка страницы авторизации");
        utils.elementWaiting(withId(R.id.enter_button), 5000);
    }
}

