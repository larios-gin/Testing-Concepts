package cat.itb.myapplication;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ActivityMainTest {

    String USER_TO_BE_TYPED = "Elver", PASSWORD_TO_BE_TYPED = "Galarga";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // ACTIVITY 2
    @Test
    public void view_elements_are_displayed() {
        onView(withId(R.id.main_activity_title)).check(matches(isDisplayed()));
        onView(withId(R.id.button_next)).check(matches(isDisplayed()));
    }

    @Test
    public void view_elements_text_are_correct() {
        onView(withId(R.id.main_activity_title)).check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.button_next)).check(matches(withText(R.string.next)));
    }

    @Test
    public void text_change_when_button_clicked() {
        onView(withId(R.id.button_next)).check(matches(isClickable()));
        onView(withId(R.id.button_next)).perform(click()).check(matches(withText("Back")));
    }


    // ACTIVITY 3
    @Test
    public void login_form_behaviour() {
        onView(withId(R.id.edit_text_username)).perform(typeText(USER_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.edit_text_password)).perform(typeText(PASSWORD_TO_BE_TYPED), closeSoftKeyboard());
    }

    @Test
    public void text_change_when_button_clicked_logged() {
        onView(withId(R.id.button_next)).check(matches(isClickable()));
        onView(withId(R.id.button_next)).perform(click()).check(matches(withText("Logged")));
    }


    // ACTIVITY 4
    @Test
    public void activity_change_when_button_clicked() {
        onView(withId(R.id.button_next)).perform(click());
    }

    @Test
    public void activity_change_when_button_clicked_and_check() {
        onView(withId(R.id.button_next)).perform(click());
        onView(withId(R.id.SecondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_next)).perform(click());
        pressBack();
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));
    }


    // ACTIVITY 5
    @Test
    public void username_and_password_introduced_in_edit_text_next_button_is_clicked_activity_changed_title_text_back_button_clicked_activity_changed_empty_edit_text() {
        onView(withId(R.id.edit_text_username)).perform(typeText(USER_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.edit_text_password)).perform(typeText(PASSWORD_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button_next)).perform(click());
        onView(withId(R.id.SecondActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.second_activity_title)).check(matches(withText("Welcome Back " + USER_TO_BE_TYPED)));
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.MainActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.edit_text_username)).check(matches(withText("")));
        onView(withId(R.id.edit_text_password)).check(matches(withText("")));
    }
}
