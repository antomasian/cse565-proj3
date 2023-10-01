package com.example.cse565_proj3

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.cse565_proj3", appContext.packageName)
    }

    @Test
    fun testNameEmpty() {

    }

    @Test
    fun testBirthdayInvalid() {

    }

    @Test
    fun checkLabelsTextSize() {

    }

    @Test
    fun checkCakeImageExistsAndSize() {

    }

    @Test
    fun testInfoToRateNav() {
        // Find a view by its ID and perform actions on it
//        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click())

        // Add assertions to verify the expected behavior
//        Espresso.onView(ViewMatchers.withId(R.id.nextButton))
//            .check(ViewAssertions.matches(ViewMatchers.withText("Next")))
    }

    @Test
    fun checkSmileyPositions() {

    }

    @Test
    fun testReasonsEmpty() {

    }

    @Test
    fun testEnterEmail() {

    }

    @Test
    fun testRateToInterestsNav() {

    }

}