package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {

    private final ViewInteraction burgerMenu = onView(
            allOf(withId(R.id.main_menu_image_button),
                    withContentDescription("Main menu"),
                    isDisplayed()));

    private final ViewInteraction aboutBurgerMenu = onView(
            allOf(withId(android.R.id.title),
                    withText("About"),
                    isDisplayed()));

    private final ViewInteraction newsBurgerMenu = onView(
            allOf(withId(android.R.id.title),
                    withText("News"),
                    isDisplayed()));

    private final ViewInteraction mainLogoView = onView(withId(R.id.trademark_image_view));
    private final ViewInteraction newsLogoView = onView(allOf(withText("News"), isDisplayed()));

    private final ViewInteraction ourMissionLogoView = onView(
            allOf(withId(R.id.our_mission_image_button),
                    withContentDescription("Our Mission")));

    private final ViewInteraction logOutButton = onView(
            allOf(withId(android.R.id.title),
                    withText("Log out"),
                    isDisplayed()));

    private final ViewInteraction authorizationBlock = onView(
            allOf(withId(R.id.authorization_image_button),
                    isDisplayed()));

    private final int mainMenuImageButtonId = R.id.main_menu_image_button;
    private final int logOutButtonId = R.id.authorization_logout_menu_item;

    public ViewInteraction getBurgerMenu() {
        return burgerMenu;
    }

    public ViewInteraction getAboutBurgerMenu() {
        return aboutBurgerMenu;
    }

    public ViewInteraction getNewsBurgerMenu() {
        return newsBurgerMenu;
    }

    public ViewInteraction getMainLogoView() {
        return mainLogoView;
    }

    public ViewInteraction getNewsLogoView() {
        return newsLogoView;
    }

    public ViewInteraction getOurMissionLogoView() {
        return ourMissionLogoView;
    }

    public ViewInteraction getLogOutButton() {
        return logOutButton;
    }

    public ViewInteraction getAuthorizationBlock() {
        return authorizationBlock;
    }

    public int getMainMenuImageButtonId() {
        return mainMenuImageButtonId;
    }

    public int getLogOutButtonId() {
        return logOutButtonId;
    }
}