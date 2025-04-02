package ru.iteco.fmhandroid.ui;

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
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.OurMissionSteps;
import ru.iteco.fmhandroid.ui.utils.Utils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Основной функционал приложения")
public class MainPageTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private MainSteps mainSteps = new MainSteps();
    private OurMissionSteps ourMissionSteps = new OurMissionSteps();
    private AboutSteps aboutSteps = new AboutSteps();
    private AuthSteps authSteps = new AuthSteps();

    @Before
    public void setUp() {
        Utils.verifyMainScreen(authSteps, mainSteps);
    }

    @Test
    @Story("Навигация по приложению")
    @Description("Проверка перехода в раздел 'Наша миссия' и отображения основных элементов")
    public void shouldOpenOurMissionSectionAndCheckElements() {
        mainSteps.clickMissionButton();
        ourMissionSteps.verifyMissionTitleDisplayed();
    }

    @Test
    @Story("Информация о приложении")
    @Description("Проверка раздела 'О приложении' с отображением политики конфиденциальности, условий использования и информации о версии")
    public void shouldDisplayAllAboutAppInformation() {
        mainSteps.openMainMenu();
        mainSteps.selectAboutInMenu();

        aboutSteps.verifyPrivacyPolicyDisplayed();
        aboutSteps.verifyTermsOfUseDisplayed();
        aboutSteps.verifyCompanyInfoDisplayed();
        aboutSteps.verifyAppVersionDisplayed();
    }
}