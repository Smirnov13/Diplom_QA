package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    private final ViewInteraction privacyPolicyView = onView(
            allOf(withId(R.id.about_privacy_policy_label_text_view),
                    withText("Privacy Policy:"),
                    isDisplayed()));

    private final ViewInteraction termsOfUseView = onView(
            allOf(withId(R.id.about_terms_of_use_label_text_view),
                    withText("Terms of use:"),
                    isDisplayed()));

    private final ViewInteraction iTecoView = onView(
            allOf(withId(R.id.about_company_info_label_text_view),
                    withText("© I-Teco, 2022"),
                    isDisplayed()));

    private final ViewInteraction versionView = onView(
            allOf(withId(R.id.about_version_title_text_view),
                    withText("Version:"),
                    isDisplayed()));

    private final int privacyPolicyViewId = R.id.about_privacy_policy_label_text_view;

    public ViewInteraction getPrivacyPolicyView() {
        return privacyPolicyView;
    }

    public ViewInteraction getTermsOfUseView() {
        return termsOfUseView;
    }

    public ViewInteraction getITecoView() {
        return iTecoView;
    }

    public ViewInteraction getVersionView() {
        return versionView;
    }

    public int getPrivacyPolicyViewId() {
        return privacyPolicyViewId;
    }
}