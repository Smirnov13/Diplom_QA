package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
public class ControlPanelSteps {
    private final ControlPanelPage controlPanelPage = new ControlPanelPage();

    public void verifySortButtonVisible() {
        Allure.step("Проверка наличия кнопки сортировки");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getSortingButtonId(), 10000));
        controlPanelPage.getSortingButton().check(matches(isDisplayed()));
    }

    public void verifyFilterButtonVisible() {
        Allure.step("Проверка наличия кнопки фильтрации");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getFilterButtonId(), 10000));
        controlPanelPage.getFilterButton().check(matches(isDisplayed()));
    }

    public void verifyEditButtonVisible() {
        Allure.step("Проверка наличия кнопки редактирования");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getEditButtonId(), 10000));
        controlPanelPage.getEditButton().check(matches(isDisplayed()));
    }

    public void clickEditButton() {
        Allure.step("Нажатие кнопки редактирования");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getNewsListSwipeRefreshId(), 5000));
        controlPanelPage.getEditButton().perform(click());
    }

    public void clickAddNewsButton() {
        Allure.step("Нажатие кнопки добавления новости");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getActionBarRootId(), 5000));
        controlPanelPage.getAddNewsButton().perform(click());
    }

    public void openCategorySelection() {
        Allure.step("Выбор категории новости");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getNavHostFragmentId(), 5000));
        onView(isRoot()).perform(waitForElement(controlPanelPage.getCategoryNewsId(), 5000));
        controlPanelPage.getCategoryNews().perform(click());
    }

    public void selectCategory(String category) {
        Allure.step("Выбор категории новости: " + category);
        onView(withText(category)).inRoot(isPlatformPopup()).perform(click());
    }

    public void enterNewsTitle(String title) {
        Allure.step("Заполнение заголовка новости: " + title);
        onView(isRoot()).perform(waitForElement(controlPanelPage.getNewsItemTitleTextInputLayoutId(), 5000));
        controlPanelPage.getFieldInputTitleNews()
                .perform(click(), replaceText(title), closeSoftKeyboard());
    }

    public void setCurrentDate() {
        Allure.step("Выбор текущей даты");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getCreateDateTextInputLayoutId(), 3000));
        controlPanelPage.getCreateDateInputLayout().perform(click());
        controlPanelPage.getOkButton().perform(click());
    }

    public void setCurrentTime() {
        Allure.step("Выбор текущего времени");
        onView(isRoot()).perform(waitForElement(controlPanelPage.getPublishTimeTextInputLayoutId(), 3000));
        controlPanelPage.getPublishTimeInputLayout().perform(click());
        controlPanelPage.getOkButton().perform(click());
    }

    public void enterDescription(String text) {
        Allure.step("Заполнение описания: " + text);
        onView(isRoot()).perform(waitForElement(controlPanelPage.getDescriptionTextInputLayoutId(), 3000));
        controlPanelPage.getDescriptionEditText().perform(click(), typeText(text), closeSoftKeyboard());
    }

    public void saveChanges() {
        Allure.step("Нажатие кнопки сохранения");
        onView(isRoot()).perform(waitForElement(R.id.save_button, 10000));
        controlPanelPage.getSaveButton().perform(scrollTo(), click());
    }

    public void verifyPanelTitleVisible() {
        Allure.step("Проверка видимости заголовка 'Control panel'");
        onView(isRoot()).perform(waitForElement(R.id.news_list_recycler_view, 5000));
        controlPanelPage.getControlPanelTitle().check(matches(withText("Control panel")));
    }

    public void verifyNewsHeaderVisible(String expectedTitle) {
        Allure.step("Проверка видимости заголовка новости: " + expectedTitle);
        onView(isRoot()).perform(waitForElement(R.id.news_item_material_card_view, 5000));
        android.os.SystemClock.sleep(3000);
        controlPanelPage.newsTitleTextView(expectedTitle).check(matches(withText(expectedTitle)));
    }

    public void clickOnFirstNews() {
        Allure.step("Клик по первой новости в списке");
        onView(isRoot()).perform(waitForElement(R.id.delete_news_item_image_view, 3000));
        onView(isRoot()).perform(waitForElement(controlPanelPage.getNewsRecyclerViewId(), 3000));
        controlPanelPage.getNewsRecyclerView().perform(actionOnItemAtPosition(0, click()));
    }

    public void verifyNewsContent(String expectedDescription) {
        Allure.step("Проверка описания новости: " + expectedDescription);
        onView(isRoot()).perform(waitForElement(R.id.news_item_publication_text_view, 5000));
        controlPanelPage.getNewsDescriptionTextView().check(matches(withText(expectedDescription)));
    }

    public void removeNewsItem(String news) {
        Allure.step("Удаление новости: " + news);
        onView(isRoot()).perform(waitForElement(R.id.delete_news_item_image_view, 3000));
        controlPanelPage.deleteNews(news).perform(click());
    }

    public void confirmDeletion() {
        Allure.step("Подтверждение удаления (нажатие OK)");
        onView(isRoot()).perform(waitForElement(android.R.id.button1, 10000));
        controlPanelPage.getOkButtonDeleteOperation().perform(scrollTo(), click());
    }

    public void verifyTextAbsent(String text) {
        Allure.step("Проверка отсутствия текста: " + text);
        android.os.SystemClock.sleep(2000);
        onView(withText(text)).check(doesNotExist());
    }

    public void editNewsItem(String text) {
        Allure.step("Нажатие кнопки редактирования для новости: " + text);
        android.os.SystemClock.sleep(2000);
        controlPanelPage.editNews(text).perform(click());
    }
}
