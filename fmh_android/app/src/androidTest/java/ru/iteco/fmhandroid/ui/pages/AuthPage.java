package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthPage {

    private final ViewInteraction inputLoginField = onView(allOf(withId(R.id.login_edit_text)));
    private final ViewInteraction inputPasswordField = onView(allOf(withId(R.id.password_edit_text)));
    private final ViewInteraction enterButton = onView(withId(R.id.enter_button));
    private final ViewInteraction toastMessageSomethingWrong = onView(withText("Something went wrong. Try again later."));
    private final ViewInteraction toastMessageEmptyLoginAndPassword = onView(withText("Login and password cannot be empty"));
    private final ViewInteraction authorizationTextView = onView(allOf(withText("Authorization"), isDisplayed()));

    private final int enterButtonId = R.id.enter_button;
    private final int loginTextInputLayoutId = R.id.login_text_input_layout;
    private final int authorizationTextId = R.id.authorization_text_input_layout;

    public ViewInteraction getInputLoginField() {
        return inputLoginField;
    }

    public ViewInteraction getInputPasswordField() {
        return inputPasswordField;
    }

    public ViewInteraction getEnterButton() {
        return enterButton;
    }

    public ViewInteraction getToastMessageSomethingWrong() {
        return toastMessageSomethingWrong;
    }

    public ViewInteraction getToastMessageEmptyLoginAndPassword() {
        return toastMessageEmptyLoginAndPassword;
    }

    public ViewInteraction getAuthorizationTextView() {
        return authorizationTextView;
    }

    public int getEnterButtonId() {
        return enterButtonId;
    }

    public int getLoginTextInputLayoutId() {
        return loginTextInputLayoutId;
    }

    public int getAuthorizationTextId() {
        return authorizationTextId;
    }
}