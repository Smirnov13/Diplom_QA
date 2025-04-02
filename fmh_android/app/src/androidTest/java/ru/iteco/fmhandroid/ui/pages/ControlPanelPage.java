package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.widget.LinearLayout;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class ControlPanelPage {

    private final ViewInteraction sortingButton = onView(
            allOf(withId(R.id.sort_news_material_button), isDisplayed()));

    private final ViewInteraction filterButton = onView(
            allOf(withId(R.id.filter_news_material_button), isDisplayed()));

    private final ViewInteraction editButton = onView(
            allOf(withId(R.id.edit_news_material_button), isDisplayed()));

    private final ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    private final ViewInteraction categoryNews = onView(withId(R.id.news_item_category_text_input_layout));
    private final ViewInteraction fieldInputTitleNews = onView(withId(R.id.news_item_title_text_input_edit_text));
    private final ViewInteraction createDateInputLayout = onView(withId(R.id.news_item_create_date_text_input_layout));
    private final ViewInteraction okButton = onView(allOf(withText("OK"), isDescendantOfA(withId(android.R.id.content))));
    private final ViewInteraction publishTimeInputLayout = onView(withId(R.id.news_item_publish_time_text_input_layout));
    private final ViewInteraction descriptionInputLayout = onView(withId(R.id.news_item_description_text_input_layout));
    private final ViewInteraction descriptionEditText = onView(withId(R.id.news_item_description_text_input_edit_text));
    private final ViewInteraction saveButton = onView(
            allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save")));

    private final ViewInteraction controlPanelTitle = onView(
            allOf(withText("Control panel"),
                    withParent(withParent(IsInstanceOf.instanceOf(LinearLayout.class))),
                    isDisplayed()));

    private final ViewInteraction deleteNewsTitleTextView = onView(
            allOf(withId(R.id.delete_news_item_image_view),
                    withContentDescription("News delete button"),
                    isDisplayed()));

    private final ViewInteraction okButtonDeleteOperation = onView(
            allOf(withId(android.R.id.button1), withText("OK")));

    private final ViewInteraction newsRecyclerView = onView(withId(R.id.news_list_recycler_view));
    private final ViewInteraction newsDescriptionTextView = onView(
            allOf(withId(R.id.news_item_description_text_view), isDisplayed()));

    // ID элементов
    private final int sortingButtonId = R.id.sort_news_material_button;
    private final int filterButtonId = R.id.filter_news_material_button;
    private final int editButtonId = R.id.edit_news_material_button;
    private final int newsListSwipeRefreshId = R.id.news_list_swipe_refresh;
    private final int actionBarRootId = R.id.action_bar_root;
    private final int navHostFragmentId = R.id.nav_host_fragment;
    private final int categoryNewsId = R.id.news_item_category_text_input_layout;
    private final int newsItemTitleTextInputLayoutId = R.id.news_item_title_text_input_layout;
    private final int createDateTextInputLayoutId = R.id.news_item_create_date_text_input_layout;
    private final int publishTimeTextInputLayoutId = R.id.news_item_publish_time_text_input_layout;
    private final int descriptionTextInputLayoutId = R.id.news_item_description_text_input_layout;
    private final int descriptionTextInputEditTextId = R.id.news_item_description_text_input_edit_text;
    private final int newsTitleTextViewId = R.id.news_item_title_text_view;
    private final int newsRecyclerViewId = R.id.news_list_recycler_view;
    private final int newsDescriptionTextViewId = R.id.news_item_description_text_view;

    // Геттеры для ViewInteraction
    public ViewInteraction getSortingButton() {
        return sortingButton;
    }

    public ViewInteraction getFilterButton() {
        return filterButton;
    }

    public ViewInteraction getEditButton() {
        return editButton;
    }

    public ViewInteraction getAddNewsButton() {
        return addNewsButton;
    }

    public ViewInteraction getCategoryNews() {
        return categoryNews;
    }

    public ViewInteraction getFieldInputTitleNews() {
        return fieldInputTitleNews;
    }

    public ViewInteraction getCreateDateInputLayout() {
        return createDateInputLayout;
    }

    public ViewInteraction getOkButton() {
        return okButton;
    }

    public ViewInteraction getPublishTimeInputLayout() {
        return publishTimeInputLayout;
    }

    public ViewInteraction getDescriptionInputLayout() {
        return descriptionInputLayout;
    }

    public ViewInteraction getDescriptionEditText() {
        return descriptionEditText;
    }

    public ViewInteraction getSaveButton() {
        return saveButton;
    }

    public ViewInteraction getControlPanelTitle() {
        return controlPanelTitle;
    }

    public ViewInteraction getDeleteNewsTitleTextView() {
        return deleteNewsTitleTextView;
    }

    public ViewInteraction getOkButtonDeleteOperation() {
        return okButtonDeleteOperation;
    }

    public ViewInteraction getNewsRecyclerView() {
        return newsRecyclerView;
    }

    public ViewInteraction getNewsDescriptionTextView() {
        return newsDescriptionTextView;
    }

    // Геттеры для ID
    public int getSortingButtonId() {
        return sortingButtonId;
    }

    public int getFilterButtonId() {
        return filterButtonId;
    }

    public int getEditButtonId() {
        return editButtonId;
    }

    public int getNewsListSwipeRefreshId() {
        return newsListSwipeRefreshId;
    }

    public int getActionBarRootId() {
        return actionBarRootId;
    }

    public int getNavHostFragmentId() {
        return navHostFragmentId;
    }

    public int getCategoryNewsId() {
        return categoryNewsId;
    }

    public int getNewsItemTitleTextInputLayoutId() {
        return newsItemTitleTextInputLayoutId;
    }

    public int getCreateDateTextInputLayoutId() {
        return createDateTextInputLayoutId;
    }

    public int getPublishTimeTextInputLayoutId() {
        return publishTimeTextInputLayoutId;
    }

    public int getDescriptionTextInputLayoutId() {
        return descriptionTextInputLayoutId;
    }

    public int getDescriptionTextInputEditTextId() {
        return descriptionTextInputEditTextId;
    }

    public int getNewsTitleTextViewId() {
        return newsTitleTextViewId;
    }

    public int getNewsRecyclerViewId() {
        return newsRecyclerViewId;
    }

    public int getNewsDescriptionTextViewId() {
        return newsDescriptionTextViewId;
    }

    // Методы для динамических элементов
    public ViewInteraction newsTitleTextView(String news) {
        return onView(
                allOf(withId(R.id.news_item_title_text_view),
                        withText(news),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()
                ));
    }

    public ViewInteraction deleteNews(String title) {
        return onView(allOf(withId(R.id.delete_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));

    }

    public ViewInteraction editNews(String title) {
        return onView(allOf(withId(R.id.edit_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));
    }
}