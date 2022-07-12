package tw.com.mathison.test20220704_1

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test

class QuizViewModelTest{
    @Test
    fun providerExpectQuestion(){
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.Question1, quizViewModel.currentQuestionText)
    }

    @Test
    fun nextExpectQuestion(){
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 1))
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.Question2, quizViewModel.currentQuestionText)
        quizViewModel.moveNext()
        assertEquals(R.string.Question3, quizViewModel.currentQuestionText)
        quizViewModel.movePrev()
        assertEquals(R.string.Question2, quizViewModel.currentQuestionText)
    }

}