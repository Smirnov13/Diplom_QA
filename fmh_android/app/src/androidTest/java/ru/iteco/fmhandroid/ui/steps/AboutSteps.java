package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.pages.AboutPage;

public class AboutSteps {
    private final AboutPage aboutPage = new AboutPage();

    public void openPrivacyPolicy() {
        Allure.step("Переход по ссылке 'Политика конфиденциальности'");
        aboutPage.getPrivacyPolicyLink().check(matches(isDisplayed()));
        aboutPage.getPrivacyPolicyLink().perform(click());
        aboutPage.getPrivacyPolicyText().check(matches(isDisplayed()));
    }

    public void openTermsOfUse() {
        Allure.step("Переход по ссылке 'Пользовательское соглашение'");
        aboutPage.getTermsOfUseLink().check(matches(isDisplayed()));
        aboutPage.getTermsOfUseLink().perform(click());
        aboutPage.getTermsOfUseText().check(matches(isDisplayed()));
    }

    public void verifyTermsOfUseOpened() {
        Allure.step("Проверка, что открылся экран Пользовательского соглашения");
        aboutPage.getTermsOfUseText().check(matches(isDisplayed()));
    }

    public void openPrivacyPolicyWithError() {
        Allure.step("Попытка открыть 'Политику конфиденциальности' с ошибкой");
        aboutPage.getPrivacyPolicyLink().check(matches(isDisplayed()));
        aboutPage.getPrivacyPolicyLink().perform(click());
        aboutPage.getErrorMessage().check(matches(isDisplayed()));
    }

    public void verifyErrorOnOpeningPrivacyPolicy() {
        Allure.step("Проверка, что появилась ошибка при открытии 'Политики конфиденциальности'");
        aboutPage.getErrorMessage().check(matches(isDisplayed()));
    }

    public void openTermsOfUseWithError() {
        Allure.step("Попытка открыть Пользовательское соглашение с ошибкой");
        aboutPage.getTermsOfUseLink().check(matches(isDisplayed()));
        aboutPage.getTermsOfUseLink().perform(click());
        aboutPage.getErrorMessage().check(matches(isDisplayed()));
    }

    public void verifyErrorOnOpeningTermsOfUse() {
        Allure.step("Проверка, что появилась ошибка при открытии 'Пользовательского соглашения'");
        aboutPage.getErrorMessage().check(matches(isDisplayed()));
    }

    public void verifyPrivacyPolicyOpened() {
        Allure.step("Проверка, что открылся экран Политики конфиденциальности");
        aboutPage.getPrivacyPolicyText().check(matches(isDisplayed()));
    }
}
