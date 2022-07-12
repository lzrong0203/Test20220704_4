package tw.com.mathison.test20220704_1

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG: String = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    private val quizBank = listOf(
        Question(R.string.Question1, false),
        Question(R.string.Question2, true),
        Question(R.string.Question3, true),
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY)?:0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)


    val currentQuestionText: Int
        get() = quizBank[currentIndex].textRsId


    val currentQuestionAnswer: Boolean
        get() = quizBank[currentIndex].answer

    fun moveNext(){
        currentIndex = (currentIndex + 1) % quizBank.size
    }

    fun movePrev(){
        currentIndex = (currentIndex - 1 + quizBank.size) % quizBank.size
    }

}