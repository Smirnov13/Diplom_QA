package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeoutException;

import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

public class Utils {
    private static final String VALID_LOGIN = "login2";
    private static final String VALID_PASSWORD = "password2";

    public static ViewAction waitForElement(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isDisplayed();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> has been displayed during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> matchId = withId(viewId);
                final Matcher<View> matchDisplayed = isDisplayed();

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        if (matchId.matches(child) && matchDisplayed.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }

    public static void verifyAuthScreen(AuthSteps authSteps, MainSteps mainSteps) {
        try {
            authSteps.verifyAuthScreenElements();
        } catch (Exception e) {
            mainSteps.performLogout();
        }
    }

    public static void verifyMainScreen(AuthSteps authSteps, MainSteps mainSteps) {
        try {
            mainSteps.verifyNewsHeaderVisible();
        } catch (Exception e) {
            authSteps.enterLogin(VALID_LOGIN);
            authSteps.enterPassword(VALID_PASSWORD);
            authSteps.clickSignInButton();
        }
    }
}