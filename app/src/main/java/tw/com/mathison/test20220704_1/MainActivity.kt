package tw.com.mathison.test20220704_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import tw.com.mathison.test20220704_1.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

//    private lateinit var trueww  Button: Button
//    private lateinit var falseButton: Button
//    private lateinit var textView: TextView

//    private val quizBank = listOf(
//        Question(R.string.Question1, false),
//        Question(R.string.Question2, true),
//        Question(R.string.Question3, true),
//    )

//    private var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "GuizViewModel: $quizViewModel")
        Log.d(TAG, "onCreate called!")
        updateQuestion()
//        this.textView = findViewById(R.id.question_text)
//        textView.setText(quizBank[currentIndex].textRsId)

//        trueButton = findViewById(R.id.true_button)
//        trueButton.setOnClickListener { view: View ->
//            checkAnswer(true)
//        }
        binding.trueButton.setOnClickListener{ view: View ->
            checkAnswer(true)
        }

//        falseButton = findViewById(R.id.false_button)
//
//        falseButton.setOnClickListener(this)
        binding.falseButton.setOnClickListener(this)



        binding.nextButton.setOnClickListener {
//            currentIndex = (currentIndex + 1) % quizBank.size
//            updateQuestion()
            quizViewModel.moveNext()
            updateQuestion()
        }

        binding.prevButton.setOnClickListener {
            quizViewModel.movePrev()
            updateQuestion()

        }

        binding.cheatButton.setOnClickListener {
            val quizAnswer = quizViewModel.currentQuestionAnswer

//            val intent = Intent(this, CheatActivity::class.java)
//            intent.putExtra("123", quizAnswer)
            val intent = CheatActivity.newIntent(this@MainActivity, quizAnswer)
            startActivity(intent)

        }


    }

    private fun updateQuestion() {

        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionText.setText(questionTextResId)
    }

    private fun checkAnswer(userAns: Boolean){
        if(quizViewModel.currentQuestionAnswer == userAns)
            Log.d(TAG, "CORRECT!!!")
        else
            Log.d(TAG, "INNNNNNNCORRECT!!!")
    }


    override fun onClick(view: View) {
        when(view.id){
            R.id.false_button -> checkAnswer(false)
            R.id.true_button -> checkAnswer(true)
            else -> Log.d(TAG, "ERROR!!!!!")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called!")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called!")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}

