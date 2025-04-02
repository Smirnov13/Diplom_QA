package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;

public class AuthSteps {
    private final AuthPage authPage = new AuthPage();

    public void enterLogin(String login) {
        Allure.step("Заполнение поля логина: " + login);
        onView(isRoot()).perform(waitForElement(authPage.getLoginTextInputLayoutId(), 10000));
        authPage.getInputLoginField().perform(replaceText(login));
    }

    public void enterPassword(String password) {
        Allure.step("Заполнение поля пароля: " + password);
        authPage.getInputPasswordField().perform(replaceText(password));
    }

    public void clickSignInButton() {
        Allure.step("Нажатие кнопки Sign In");
        onView(isRoot()).perform(waitForElement(authPage.getEnterButtonId(), 5000));
        authPage.getEnterButton().perform(click());
    }

    public void verifyEmptyFieldsErrorMessage(ActivityScenarioRule<AppActivity> mActivityScenarioRule) {
        Allure.step("Проверка сообщения о не пустом пароле и логине");
        final View[] decorView = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            decorView[0] = activity.getWindow().getDecorView();
        });
        authPage.getToastMessageEmptyLoginAndPassword()
                .inRoot(withDecorView(not(is(decorView[0]))))
                .check(matches(isDisplayed()));
    }

    public void verifySomethingWrongErrorMessage(ActivityScenarioRule<AppActivity> mActivityScenarioRule) {
        Allure.step("Проверка сообщения о том, что что-то пошло не так");
        final View[] decorView = new View[1];
        mActivityScenarioRule.getScenario().onActivity(activity -> {
            decorView[0] = activity.getWindow().getDecorView();
        });
        authPage.getToastMessageSomethingWrong()
                .inRoot(withDecorView(not(is(decorView[0]))))
                .check(matches(isDisplayed()));
    }

    public void verifyAuthScreenElements() {
        Allure.step("Проверка наличия текста авторизации");
        onView(isRoot()).perform(waitForElement(authPage.getAuthorizationTextId(), 10000));
    }
}