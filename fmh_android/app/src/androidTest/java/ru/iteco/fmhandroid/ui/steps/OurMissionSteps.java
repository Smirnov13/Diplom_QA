package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;

public class OurMissionSteps {
    private final OurMissionPage ourMissionPage = new OurMissionPage();

    public void verifyMissionTitleDisplayed() {
        Allure.step("Проверка открытия страницы Наша Миссия");
        onView(isRoot()).perform(waitForElement(ourMissionPage.getOurMissionLabelId(), 10000));
        ourMissionPage.getOurMissionLabelView().check(matches(isDisplayed()));
    }
}
