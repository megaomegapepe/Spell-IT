package application.spellit

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val EXTRA_ANSWER = "application.spellit.answer"
const val EXTRA_ANSWER_SHOWN = "application.spellit.answer_shown"

class CheatActivity : AppCompatActivity() {

    private lateinit var answerButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        val correctAnswer = intent.getBooleanExtra(EXTRA_ANSWER, false)

        textView = findViewById(R.id.answer_text_view)
        answerButton = findViewById(R.id.show_answer_button)
        answerButton.setOnClickListener {
            val answer = when (correctAnswer) {
                true -> R.string.true_button
                else -> R.string.false_button
            }
            textView.setText(answer)
            setAnswerShownResult(true)
        }
    }

    //Call when user clicked on cheating button
    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val resultData = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, resultData)
    }

    companion object {
        fun newIntent(context: Context, answer: Boolean): Intent {
            return Intent(context, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER, answer)
            }
        }
    }
}