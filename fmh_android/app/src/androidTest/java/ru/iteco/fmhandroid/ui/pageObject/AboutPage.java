package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
public class AboutPage {

    public ViewInteraction privacyPolicyText = onView(withText("Политика конфиденциальности"));
    public ViewInteraction termsOfUseText = onView(withText("Пользовательское соглашение"));
    public ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));


    @Step("Переход на страницу Политика конфиденциальности")
    public void openPrivacyPolicy() {
        privacyPolicyLink.check(matches(isDisplayed()));
        privacyPolicyLink.perform(click());
        privacyPolicyText.check(matches(isDisplayed()));
    }

    @Step("Переход на страницу Пользовательское соглашение")
    public void openTermsOfUse() {
        termsOfUseLink.check(matches(isDisplayed()));
        termsOfUseLink.perform(click());
        termsOfUseText.check(matches(isDisplayed()));
    }
}
