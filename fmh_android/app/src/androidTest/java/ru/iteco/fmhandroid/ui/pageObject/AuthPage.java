package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
public class AuthPage {

    public static final ViewInteraction logoImage = onView(withId(R.id.trademark_image_view));
    public static final ViewInteraction usernameInput = onView(withId(R.id.login_text_input_layout));
    public static final ViewInteraction passwordInput = onView(withId(R.id.password_text_input_layout));
    public static final ViewInteraction loginButton = onView(withId(R.id.enter_button));

    @Step("Заполнение полей логина и пароля")
    public void fillCreds(String username, String password) {
        usernameInput.perform(replaceText(username), closeSoftKeyboard());
        passwordInput.perform(replaceText(password), closeSoftKeyboard());
    }

    @Step("Клик по кнопке входа")
    public void tapLoginButton() {
        loginButton.perform(click());
    }

    @Step("Подтверждение успешного входа")
    public void verifyLoginSuccess() {
        logoImage.check(matches(isDisplayed()));
    }

}
