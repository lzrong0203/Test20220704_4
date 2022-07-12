package tw.com.mathison.test20220704_1

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun showFirstQuestion(){
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.Question1)))
    }

    @Test
    fun showsSecondQuestionAfterNextPress() {
        onView(withId(R.id.next_button)).perform(ViewActions.click())
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.Question2)))
    }

    @Test
    fun handlesActivityRecreation() {
        onView(withId(R.id.next_button)).perform(ViewActions.click())
        scenario.recreate()
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.Question2)))
    }
}