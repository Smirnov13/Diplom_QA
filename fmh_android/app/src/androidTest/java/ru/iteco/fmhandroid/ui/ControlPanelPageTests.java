package ru.iteco.fmhandroid.ui;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.config.ConfigProperties;
import ru.iteco.fmhandroid.ui.pageObject.AuthPage;
import ru.iteco.fmhandroid.ui.pageObject.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pageObject.MainPage;
import ru.iteco.fmhandroid.ui.utils.Utils;

@Epic("Управление новостями")
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelPageTests {
    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    private MainPage mainPage;
    private ControlPanelPage controlPanelPage;
    public AuthPage authPage;
    public Utils utils;

    @Before
    public void init() {
        mainPage = new MainPage();
        controlPanelPage = new ControlPanelPage();
        authPage = new AuthPage();
        utils = new Utils();

        utils.downloadApp();
        authPage.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authPage.tapLoginButton();
        activityRule = new ActivityScenarioRule<>(AppActivity.class);
    }

    @Test
    @Feature("Создание новости")
    @Story("Создание новости во вкладке 'Control Panel'")
    @DisplayName("Создание новости")
    @Description("Проверка успешного создания новости и её отображения в списке")
    public void createNews() {
        Allure.step("Открытие раздела новостей");
        mainPage.openNewsSection();

        Allure.step("Переход в режим редактирования новостей");
        controlPanelPage.navigateToEditNews();

        Allure.step("Создание новости");
        controlPanelPage.clickCreateNews();
        controlPanelPage.fillNewsDetails("Описание", "Какой-то тайтл");

        Allure.step("Проверка наличия новости");
        assertThat(controlPanelPage.isNewsDisplayed("Какой-то тайтл"), is(true));
    }

    @Test
    @Feature("Удаление новости")
    @Story("Удаление новости во вкладке 'Control Panel'")
    @DisplayName("Удаление новости")
    @Description("Проверка успешного удаления новости")
    public void deleteNews() {
        createNews(); // Предусловие

        Allure.step("Удаление новости");
        controlPanelPage.deleteNews("Какой-то тайтл");

        Allure.step("Проверка отсутствия новости");
        assertThat(controlPanelPage.isNewsDisplayed("Какой-то тайтл"), is(false));
    }

    @Test
    @Feature("Редактирование новости")
    @Story("Редактирование новости во вкладке 'Control Panel'")
    @DisplayName("Редактирование новости")
    @Description("Проверка возможности редактирования новости")
    public void editNews() {
        createNews(); // Предусловие

        Allure.step("Редактирование новости");
        controlPanelPage.editNews("Какой-то тайтл");
        controlPanelPage.updateNews("Новое описание");

        Allure.step("Проверка обновленного описания");
        assertThat(controlPanelPage.isNewsDescriptionUpdated("Какой-то тайтл", "Новое описание"), is(true));
    }

    @Test
    @Feature("Смена статуса")
    @Story("Смена статуса новости с 'Active' на 'Not Active'")
    @DisplayName("Смена статуса новости")
    @Description("Проверка возможности смены статуса новости")
    public void changeStatusOfNews() {
        createNews(); // Предусловие

        Allure.step("Смена статуса новости");
        controlPanelPage.toggleNewsStatus();
        Allure.step("Проверка изменения статуса");
        assertThat(controlPanelPage.isNewsStatusChanged("Какой-то тайтл"), is(true));
    }

    @Test
    @Feature("Негативные тесты")
    @Story("Попытка создания новости с пустыми полями")
    @DisplayName("Создание новости без данных")
    @Description("Проверка, что нельзя создать новость с пустыми полями")
    public void createNewsWithEmptyFields() {
        Allure.step("Открытие раздела новостей");
        mainPage.openNewsSection();

        Allure.step("Переход в режим редактирования новостей");
        controlPanelPage.navigateToEditNews();

        Allure.step("Попытка создания новости с пустыми полями");
        controlPanelPage.clickCreateNews();
        controlPanelPage.fillNewsDetails("", "");

        Allure.step("Проверка наличия ошибки");
        assertThat(controlPanelPage.isErrorDisplayed(), is(true));
    }

}
