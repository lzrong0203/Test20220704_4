package tw.com.mathison.test20220704_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tw.com.mathison.test20220704_1.databinding.ActivityCheatBinding

private const val TAG = "CheatActivity"
const val EXTRA_ANSWER = "tw.com.mathison.test20220704_1.show_answer"


class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "CHEAT!!!")

        val ansIsTrue = intent.getBooleanExtra(EXTRA_ANSWER, false)

        binding.cheatButton.setOnClickListener {
            val answerText = when{
                ansIsTrue -> R.string.button_true
                else -> R.string.button_false
            }
            binding.answerTextView.setText(answerText)
        }
    }

    companion object{
        fun newIntent(context: Context, answer: Boolean): Intent{
            return Intent(context, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER, answer)
            }
        }
    }


}