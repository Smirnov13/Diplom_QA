package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class ControlPanelPage {
    private final ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));
    private final ViewInteraction activeSwitch = onView(withId(R.id.switcher));
    private final ViewInteraction newsPage = onView(withId(R.id.all_news_cards_block_constraint_layout));
    private final ViewInteraction controlPanelPageView = onView(withId(R.id.news_list_recycler_view));

    public ViewInteraction getCreateNewsButton() {
        return createNewsButton;
    }

    public ViewInteraction getActiveSwitch() {
        return activeSwitch;
    }

    public ViewInteraction getNewsPage() {
        return newsPage;
    }

    public ViewInteraction getControlPanelPageView() {
        return controlPanelPageView;
    }

    public Matcher<View> editNewsButton() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public Matcher<View> chooseCategoryButton() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public Matcher<View> categoryAnnouncement() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public Matcher<View> publishDateButton() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public Matcher<View> confirmButton() {
        return allOf(withId(android.R.id.button1));
    }

    public Matcher<View> chooseTimeButton() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public Matcher<View> descriptionField() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public Matcher<View> saveButton() {
        return allOf(withId(R.id.save_button));
    }

    public Matcher<View> editButton() {
        return allOf(withId(R.id.edit_news_item_image_view));
    }

    public Matcher<View> titleField() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }
}
