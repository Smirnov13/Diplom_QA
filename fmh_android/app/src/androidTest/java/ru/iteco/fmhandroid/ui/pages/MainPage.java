package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {

    private final ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction newsSectionButton = onView(withText("News"));
    private final ViewInteraction aboutSectionButton = onView(withText("About"));

    private final ViewInteraction missionIconButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction newsPage = onView(withId(R.id.all_news_cards_block_constraint_layout));
    private final ViewInteraction aboutPageVersion = onView(withId(R.id.about_version_title_text_view));
    private final ViewInteraction missionPageTitle = onView(withId(R.id.our_mission_title_text_view));
    private final ViewInteraction errorTitle = onView(withId(R.id.tag_unhandled_key_listeners));

    public ViewInteraction getNewsPage() {
        return newsPage;
    }

    public ViewInteraction getMenuButton() {
        return menuButton;
    }

    public ViewInteraction getNewsSectionButton() {
        return newsSectionButton;
    }

    public ViewInteraction getAboutSectionButton() {
        return aboutSectionButton;
    }

    public ViewInteraction getMissionIconButton() {
        return missionIconButton;
    }

    public ViewInteraction getAboutPageVersion() {
        return aboutPageVersion;
    }

    public ViewInteraction getMissionPageTitle() {
        return missionPageTitle;
    }

    public ViewInteraction getErrorTitle() {
        return errorTitle;
    }
}
