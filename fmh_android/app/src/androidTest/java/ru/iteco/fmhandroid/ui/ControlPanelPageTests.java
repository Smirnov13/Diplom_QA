package ru.iteco.fmhandroid.ui;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.pageObject.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;

@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelPageTests {
    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    private MainPage mainPage;
    private ControlPanelPage controlPanelPage;

    @Before
    public void init() {
        mainPage = new MainPage();
        controlPanelPage = new ControlPanelPage();
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
    }

    @Test
    @Story("Создание новости во вкладке 'Control Panel'")
    public void createNews() {
        mainPage.openNewsSection();
        controlPanelPage.navigateToEditNews();
        controlPanelPage.clickCreateNews();
        controlPanelPage.fillNewsDetails("Описание", "Какой-то тайтл");
        controlPanelPage.deleteNews("Какой-то тайтл");
    }

    @Test
    @Story("Удаление новости во вкладке 'Control Panel'")
    public void deleteNews() {
        mainPage.openNewsSection();
        controlPanelPage.navigateToEditNews();
        controlPanelPage.clickCreateNews();
        controlPanelPage.fillNewsDetails("Описание", "Какой-то тайтл");
        controlPanelPage.deleteNews("Какой-то тайтл");
    }

    @Test
    @Story("Редактирование новости во вкладке 'Control Panel'")
    public void editNews() {
        mainPage.openNewsSection();
        controlPanelPage.navigateToEditNews();
        controlPanelPage.clickCreateNews();
        controlPanelPage.fillNewsDetails("Описание", "Какой-то тайтл");
        controlPanelPage.editNews("Какой-то тайтл номер 2");
        controlPanelPage.updateNews("Описание 2");
        controlPanelPage.deleteNews("Какой-то тайтл номер 2");
    }

    @Test
    @Story("Смена статуса новости с 'Active' на 'Not Active' во вкладке 'Control Panel'")
    public void changeStatusOfNews() {
        mainPage.openNewsSection();
        controlPanelPage.navigateToEditNews();
        controlPanelPage.clickCreateNews();
        controlPanelPage.fillNewsDetails("Описание", "Какой-то тайтл");
        controlPanelPage.editNews("Какой-то тайтл номер 3");
        controlPanelPage.toggleNewsStatus();
        controlPanelPage.deleteNews("Какой-то тайтл номер 3");
    }
}
