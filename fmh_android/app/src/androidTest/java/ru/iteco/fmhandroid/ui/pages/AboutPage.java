package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {
    private final ViewInteraction privacyPolicyText = onView(withText("Политика конфиденциальности"));
    private final ViewInteraction termsOfUseText = onView(withText("Пользовательское соглашение"));
    private final ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    private final ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
    private final ViewInteraction errorMessage = onView(withId(R.id.news_item_publication_date_text_view));


    public ViewInteraction getPrivacyPolicyText() {
        return privacyPolicyText;
    }

    public ViewInteraction getTermsOfUseText() {
        return termsOfUseText;
    }

    public ViewInteraction getPrivacyPolicyLink() {
        return privacyPolicyLink;
    }

    public ViewInteraction getTermsOfUseLink() {
        return termsOfUseLink;
    }

    public ViewInteraction getErrorMessage() {
        return errorMessage;
    }
}
