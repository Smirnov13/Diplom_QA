package ru.iteco.fmhandroid.ui;

import static ru.iteco.fmhandroid.ui.utils.Constants.NEWS_CATEGORY;
import static ru.iteco.fmhandroid.ui.utils.Constants.NEWS_DESCRIPTION;
import static ru.iteco.fmhandroid.ui.utils.Constants.NEWS_TITLE;
import static ru.iteco.fmhandroid.ui.utils.Constants.NEWS_TITLE_DELETE;
import static ru.iteco.fmhandroid.ui.utils.Constants.NEWS_TITLE_UPDATE;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Функционал новостей")
public class ControlPanelPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private MainSteps mainSteps = new MainSteps();
    private ControlPanelSteps controlPanelSteps = new ControlPanelSteps();
    private AboutSteps aboutSteps = new AboutSteps();
    private AuthSteps authSteps = new AuthSteps();

    @Before
    public void setUp() {
        Utils.verifyMainScreen(authSteps, mainSteps);
    }

    @Test
    @Story("Элементы управления новостями")
    @Description("Проверка отображения основных элементов управления на странице новостей")
    public void shouldDisplayNewsControlElements() {
        mainSteps.openMainMenu();
        mainSteps.selectNewsInMenu();

        controlPanelSteps.verifySortButtonVisible();
        controlPanelSteps.verifyFilterButtonVisible();
        controlPanelSteps.verifyEditButtonVisible();
    }

    @Test
    @Story("Создание новости")
    @Description("Проверка создания новости")
    public void shouldCreateNewsWithValidData() {
        navigateToControlPanel();
        createNews(NEWS_TITLE);
        controlPanelSteps.verifyNewsContent(NEWS_DESCRIPTION);
        controlPanelSteps.verifyNewsHeaderVisible(NEWS_TITLE);
    }

    @Test
    @Story("Удаление новости")
    @Description("Проверка удаления созданной новости")
    public void shouldDeleteCreatedNews() {
        navigateToControlPanel();
        createNews(NEWS_TITLE_DELETE);

        controlPanelSteps.removeNewsItem(NEWS_TITLE_DELETE);
        controlPanelSteps.confirmDeletion();
        controlPanelSteps.verifyTextAbsent(NEWS_TITLE_DELETE);
    }

    @Test
    @Story("Редактирование новости")
    @Description("Проверка редактирования существующей новости")
    public void shouldEditExistingNews() {
        navigateToControlPanel();
        createNews(NEWS_TITLE);

        controlPanelSteps.editNewsItem(NEWS_TITLE);
        controlPanelSteps.enterNewsTitle(NEWS_TITLE_UPDATE);
        controlPanelSteps.saveChanges();

        controlPanelSteps.verifyNewsHeaderVisible(NEWS_TITLE_UPDATE);
    }

    @Test
    @Story("Навигация")
    @Description("Проверка перехода на страницу 'О приложении' из раздела новостей")
    public void shouldNavigateToAboutFromNewsSection() {
        mainSteps.openMainMenu();
        mainSteps.selectNewsInMenu();
        mainSteps.openMainMenu();
        mainSteps.selectAboutInMenu();

        aboutSteps.verifyPrivacyPolicyDisplayed();
        aboutSteps.verifyTermsOfUseDisplayed();
        aboutSteps.verifyAppVersionDisplayed();
    }

    private void navigateToControlPanel() {
        mainSteps.openMainMenu();
        mainSteps.selectNewsInMenu();
        controlPanelSteps.clickEditButton();
    }

    private void createNews(String title) {
        controlPanelSteps.clickAddNewsButton();
        controlPanelSteps.openCategorySelection();
        controlPanelSteps.selectCategory(NEWS_CATEGORY);
        controlPanelSteps.enterNewsTitle(title);
        controlPanelSteps.setCurrentDate();
        controlPanelSteps.setCurrentTime();
        controlPanelSteps.enterDescription(NEWS_DESCRIPTION);
        controlPanelSteps.saveChanges();
        controlPanelSteps.clickOnFirstNews();
    }
}