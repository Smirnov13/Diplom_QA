package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitForElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.AboutPage;

public class AboutSteps {
    private final AboutPage aboutPage = new AboutPage();

    public void verifyPrivacyPolicyDisplayed() {
        Allure.step("Проверка отображения политики конфиденциальности");
        onView(isRoot()).perform(waitForElement(aboutPage.getPrivacyPolicyViewId(), 10000));
        aboutPage.getPrivacyPolicyView().check(matches(isDisplayed()));
    }

    public void verifyTermsOfUseDisplayed() {
        Allure.step("Проверка отображения условий использования");
        aboutPage.getTermsOfUseView().check(matches(isDisplayed()));
    }

    public void verifyAppVersionDisplayed() {
        Allure.step("Проверка отображения версии приложения");
        aboutPage.getVersionView().check(matches(isDisplayed()));
    }

    public void verifyCompanyInfoDisplayed() {
        Allure.step("Проверка отображения информации о ITECO");
        aboutPage.getITecoView().check(matches(isDisplayed()));
    }
}