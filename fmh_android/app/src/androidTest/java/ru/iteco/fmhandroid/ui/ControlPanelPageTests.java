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
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@Epic("Управление новостями")
@RunWith(AllureAndroidJUnit4.class)
public class ControlPanelPageTests {
    @Rule
    public ActivityScenarioRule<AppActivity> activityRule;
    private MainSteps mainSteps;
    private ControlPanelSteps ControlPanelSteps;
    public AuthSteps authSteps;
    public Utils utils;

    private static final String DESCRIPTION = "Описание";
    private static final String TITLE = "Тайтл";
    private static final String NEW_TITLE = "Новый тайтл";

    @Before
    public void init() {
        mainSteps = new MainSteps();
        ControlPanelSteps = new ControlPanelSteps();
        authSteps = new AuthSteps();
        utils = new Utils();

        utils.downloadApp();

        try {
            authSteps.openAuthPage();
        } catch (Exception e) {
            authSteps.logout();
            authSteps.openAuthPage();
        }
        authSteps.fillCreds(ConfigProperties.getLogin(), ConfigProperties.getPassword());
        authSteps.tapLoginButton();
        activityRule = new ActivityScenarioRule<>(AppActivity.class);

    }

    @Test
    @Story("Создание новости во вкладке 'Control Panel'")
    @Description("Проверка успешного создания новости и её отображения в списке")
    public void createNews() {
        mainSteps.openNewsSection();
        ControlPanelSteps.navigateToEditNews();
        ControlPanelSteps.clickCreateNews();
        ControlPanelSteps.fillNewsDetails(DESCRIPTION, TITLE);
        assertThat(ControlPanelSteps.isNewsDisplayed(TITLE), is(true));
    }

    @Test
    @Story("Удаление новости во вкладке 'Control Panel'")
    @Description("Проверка успешного удаления новости")
    public void deleteNews() {
        createNews(); // Предусловие
        ControlPanelSteps.deleteNews(TITLE);
        assertThat(ControlPanelSteps.isNewsDisplayed(TITLE), is(false));
    }

    @Test
    @Story("Редактирование новости во вкладке 'Control Panel'")
    @Description("Проверка возможности редактирования новости")
    public void editNews() {
        createNews(); // Предусловие

        ControlPanelSteps.editNews(TITLE);
        ControlPanelSteps.updateNews(NEW_TITLE);
        assertThat(ControlPanelSteps.isNewsDescriptionUpdated(TITLE, NEW_TITLE), is(true));
    }

    @Test
    @Story("Смена статуса новости с 'Active' на 'Not Active'")
    @Description("Проверка возможности смены статуса новости")
    public void changeStatusOfNews() {
        createNews(); // Предусловие
        ControlPanelSteps.toggleNewsStatus();
        assertThat(ControlPanelSteps.isNewsStatusChanged(TITLE), is(true));
    }

    @Test
    @Story("Попытка создания новости с пустыми полями")
    @Description("Проверка, что нельзя создать новость с пустыми полями")
    public void createNewsWithEmptyFields() {
        mainSteps.openNewsSection();
        ControlPanelSteps.navigateToEditNews();
        ControlPanelSteps.clickCreateNews();
        ControlPanelSteps.fillNewsDetails("", "");
        assertThat(ControlPanelSteps.isErrorDisplayed(), is(true));
    }

}
