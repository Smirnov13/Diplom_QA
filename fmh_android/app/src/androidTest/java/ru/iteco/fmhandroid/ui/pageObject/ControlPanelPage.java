package ru.iteco.fmhandroid.ui.pageObject;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class ControlPanelPage {

    public ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));
    public ViewInteraction activeSwitch = onView(withId(R.id.switcher));
    public ViewInteraction newsPage = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public ViewInteraction controlPanelPage = onView(withId(R.id.news_list_recycler_view));

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

    @Step("Создание новой новости")
    public void clickCreateNews() {
        Allure.step("Открытие экрана создания новости");
        createNewsButton.check(matches(isDisplayed()));
        createNewsButton.perform(click());
    }

    @Step("Удаление новости")
    public void deleteNews(String title) {
        onView(confirmButton()).perform(click());
    }

    @Step("Редактирование новости")
    public void editNews(String title) {
        onView(editButton()).perform(click());
    }

    @Step("Активация/деактивация новости и сохранение изменений")
    public void toggleNewsStatus() {
        activeSwitch.check(matches(isDisplayed()));
        activeSwitch.perform(click());
        onView(saveButton()).check(matches(isDisplayed()));
        onView(saveButton()).perform(click());
        controlPanelPage.check(matches(isDisplayed()));
    }

    @Step("Заполнение данных новости")
    public void fillNewsDetails(String description, String titleName) {
        Allure.step("Заполнение заголовка: " + titleName + " и описания");
        onView(chooseCategoryButton()).check(matches(isDisplayed()));
        onView(chooseCategoryButton()).perform(click());
        onView(categoryAnnouncement()).check(matches(isDisplayed()));
        onView(categoryAnnouncement()).perform(click(), replaceText("Объявление"), closeSoftKeyboard());
        onView(titleField()).check(matches(isDisplayed()));
        onView(titleField()).perform(click(), replaceText(titleName), closeSoftKeyboard());
        onView(publishDateButton()).check(matches(isDisplayed()));
        onView(publishDateButton()).perform(click());
        onView(confirmButton()).check(matches(isDisplayed()));
        onView(confirmButton()).perform(click());
        onView(chooseTimeButton()).check(matches(isDisplayed()));
        onView(chooseTimeButton()).perform(click());
        onView(confirmButton()).perform(click());
        onView(descriptionField()).check(matches(isDisplayed()));
        onView(descriptionField()).perform(replaceText(description), closeSoftKeyboard());
        onView(saveButton()).check(matches(isDisplayed()));
        onView(saveButton()).perform(click());
    }

    @Step("Редактирование существующей новости")
    public void updateNews(String description) {
        onView(descriptionField()).check(matches(isDisplayed()));
        onView(descriptionField()).perform(replaceText(description), closeSoftKeyboard());
        onView(saveButton()).check(matches(isDisplayed()));
        onView(saveButton()).perform(click());
        controlPanelPage.check(matches(isDisplayed()));
    }

    @Step("Переход к редактированию новости")
    public void navigateToEditNews() {
        onView(editNewsButton()).check(matches(isDisplayed()));
        onView(editNewsButton()).perform(click());
        controlPanelPage.check(matches(isDisplayed()));
    }

    @Step("Проверка наличия новости")
    public boolean isNewsDisplayed(String title) {
        onView(withText(title)).check(matches(isDisplayed()));
        return true;
    }

    @Step("Проверка обновления описания новости")
    public boolean isNewsDescriptionUpdated(String title, String newDescription) {
        onView(withText(newDescription)).check(matches(isDisplayed()));
        return true;
    }

    @Step("Проверка смены статуса новости для {title}")
    public boolean isNewsStatusChanged(String title) {
        try {
            onView(withText(title)).check(matches(isDisplayed()));
            onView(withId(R.id.switcher)).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Проверка наличия ошибки при создании новости")
    public boolean isErrorDisplayed() {
        onView(withText("Ошибка")).check(matches(isDisplayed()));
        return true;
    }
}
