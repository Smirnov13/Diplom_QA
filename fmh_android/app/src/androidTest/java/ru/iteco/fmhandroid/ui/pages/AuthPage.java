package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthPage {
    private final ViewInteraction logoImage = onView(withId(R.id.trademark_image_view));
    private final ViewInteraction usernameInput = onView(withId(R.id.login_text_input_layout));
    private final ViewInteraction passwordInput = onView(withId(R.id.password_text_input_layout));
    private final ViewInteraction enterButton = onView(withId(R.id.enter_button));
    private final ViewInteraction errorText = onView(withText("Invalid credentials"));
    private final ViewInteraction authorization = onView(allOf(withText("Authorization")));
    private final ViewInteraction logInButton = onView(withId(R.id.authorization_image_button));
    private final ViewInteraction logOutButton = onView(withText("Log out"));

    public ViewInteraction getAuthorization() {
        return authorization;
    }

    public ViewInteraction getLogInButton() {
        return logInButton;
    }

    public ViewInteraction getLogOutButton() {
        return logOutButton;
    }

    public ViewInteraction getUsernameInput() {
        return usernameInput;
    }

    public ViewInteraction getLogoImage() {
        return logoImage;
    }

    public ViewInteraction getPasswordInput() {
        return passwordInput;
    }

    public ViewInteraction getEnterButton() {
        return enterButton;
    }

    public ViewInteraction getErrorText() {
        return errorText;
    }
}
