package com.example.picknmixologist;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainActivityTest {

    @Test
    void onCreate() {

            assertEquals(4, 2 + 2);

    }

    @Test
    public void testLaunchActivity() {
        onView(withId(R.id.button2)).check(matches(withText("Camera")));
    }
}