package ru.iteco.fmhandroid.ui.steps;


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
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;

public class ControlPanelSteps {
    private final ControlPanelPage controlPanelPage = new ControlPanelPage();

    public void clickCreateNews() {
        Allure.step("Открытие экрана создания новости");
        controlPanelPage.getCreateNewsButton().check(matches(isDisplayed()));
        controlPanelPage.getCreateNewsButton().perform(click());
    }

    public void deleteNews(String title) {
        Allure.step("Удаление новости");
        onView(controlPanelPage.confirmButton()).perform(click());
    }

    public void editNews(String title) {
        Allure.step("Редактирование новости");
        onView(controlPanelPage.editButton()).perform(click());
    }

    public void toggleNewsStatus() {
        Allure.step("Смена статуса новости");
        controlPanelPage.getActiveSwitch().check(matches(isDisplayed()));
        controlPanelPage.getActiveSwitch().perform(click());
        onView(controlPanelPage.saveButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.saveButton()).perform(click());
        controlPanelPage.getControlPanelPageView().check(matches(isDisplayed()));
    }

    @Step("Заполнение данных новости")
    public void fillNewsDetails(String description, String titleName) {
        Allure.step("Заполнение заголовка: " + titleName + " и описания");
        onView(controlPanelPage.chooseCategoryButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.chooseCategoryButton()).perform(click());
        onView(controlPanelPage.categoryAnnouncement()).check(matches(isDisplayed()));
        onView(controlPanelPage.categoryAnnouncement()).perform(click(), replaceText("Объявление"), closeSoftKeyboard());
        onView(controlPanelPage.titleField()).check(matches(isDisplayed()));
        onView(controlPanelPage.titleField()).perform(click(), replaceText(titleName), closeSoftKeyboard());
        onView(controlPanelPage.publishDateButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.publishDateButton()).perform(click());
        onView(controlPanelPage.confirmButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.confirmButton()).perform(click());
        onView(controlPanelPage.chooseTimeButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.chooseTimeButton()).perform(click());
        onView(controlPanelPage.confirmButton()).perform(click());
        onView(controlPanelPage.descriptionField()).check(matches(isDisplayed()));
        onView(controlPanelPage.descriptionField()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.saveButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.saveButton()).perform(click());
    }

    @Step("Редактирование существующей новости")
    public void updateNews(String description) {
        onView(controlPanelPage.descriptionField()).check(matches(isDisplayed()));
        onView(controlPanelPage.descriptionField()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.saveButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.saveButton()).perform(click());
        controlPanelPage.getControlPanelPageView().check(matches(isDisplayed()));
    }

    public void navigateToEditNews() {
        Allure.step("Переход в режим редактирования новостей");
        onView(controlPanelPage.editNewsButton()).check(matches(isDisplayed()));
        onView(controlPanelPage.editNewsButton()).perform(click());
        controlPanelPage.getControlPanelPageView().check(matches(isDisplayed()));
    }

    public boolean isNewsDisplayed(String title) {
        Allure.step("Проверка наличия новости");
        onView(withText(title)).check(matches(isDisplayed()));
        return true;
    }

    public boolean isNewsDescriptionUpdated(String title, String newDescription) {
        Allure.step("Проверка обновленного описания");
        onView(withText(newDescription)).check(matches(isDisplayed()));
        return true;
    }

    public boolean isNewsStatusChanged(String title) {
        Allure.step("Проверка изменения статуса");
        try {
            onView(withText(title)).check(matches(isDisplayed()));
            onView(withId(R.id.switcher)).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isErrorDisplayed() {
        Allure.step("Проверка наличия ошибки");
        onView(withText("Ошибка")).check(matches(isDisplayed()));
        return true;
    }
}
