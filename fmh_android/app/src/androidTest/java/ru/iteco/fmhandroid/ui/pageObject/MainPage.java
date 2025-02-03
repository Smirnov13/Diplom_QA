package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class MainPage {
    public ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction newsSectionButton = onView(withText("News"));
    public ViewInteraction aboutSectionButton = onView(withText("About"));
    public ViewInteraction missionIconButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction newsPage = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public ViewInteraction aboutPageVersion = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction missionPageTitle = onView(withId(R.id.our_mission_title_text_view));

    @Step("Открыть раздел 'Новости'")
    public void openNewsSection() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());
        newsSectionButton.check(matches(isDisplayed()));
        newsSectionButton.perform(click());
        newsPage.check(matches(isDisplayed()));
    }

    @Step("Открыть раздел 'О проекте'")
    public void openAboutSection() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());
        newsSectionButton.check(matches(isDisplayed()));
        aboutSectionButton.perform(click());
        aboutPageVersion.check(matches(isDisplayed()));
    }

    @Step("Перейти в раздел 'Наша миссия'")
    public void openMissionSection() {
        missionIconButton.check(matches(isDisplayed()));
        missionIconButton.perform(click());
        missionPageTitle.check(matches(isDisplayed()));
    }
}
