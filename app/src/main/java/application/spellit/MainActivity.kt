package application.spellit

<<<<<<< HEAD
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
=======
>>>>>>> main
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import application.spellit.viewmodels.MainActivityViewModel

private const val KEY_INDEX = "index"
<<<<<<< HEAD
private const val REQUEST_CODE_CHEAT = 0
=======
>>>>>>> main

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
<<<<<<< HEAD
    private lateinit var cheatButton: Button
=======
>>>>>>> main
    private lateinit var questionTextView: TextView

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    //This method will call when our activity will be created from application.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)          //We always need to call super method of super class first string after overriding method
        setContentView(R.layout.activity_main)      //In folder "res" of this project you can find xml activity main. This xml file will configure the view of our activity, and we set this on out View of out Activity of out project. Like in USSR.

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        viewModel.setCurrentIndex(currentIndex)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
<<<<<<< HEAD
        cheatButton = findViewById(R.id.cheat_button)
=======
>>>>>>> main
        questionTextView = findViewById(R.id.question_text_view)
        questionTextView.setText(R.string.first_question)

        //Set clickListeners
        trueButton.setOnClickListener { view: View -> checkUserAnswer(true) }

        falseButton.setOnClickListener { view: View -> checkUserAnswer(false) }

        nextButton.setOnClickListener { view: View ->
            viewModel.nextQuestion()
            questionTextView.setText(viewModel.getQuestion().textResId)
        }
<<<<<<< HEAD

        cheatButton.setOnClickListener { view: View ->
            val answer = viewModel.getQuestion().answer
            val intent = CheatActivity.newIntent(this@MainActivity, answer)
            val options =
                ActivityOptions.makeClipRevealAnimation(view, 0, 0, view.width, view.height)
            startActivityForResult(intent, REQUEST_CODE_CHEAT, options.toBundle())

        }
=======
>>>>>>> main
    }

    //Override for save data after android kill application process
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i("MainActivity", "call onSaveInstance")
        savedInstanceState.putInt(KEY_INDEX, viewModel.getCurrentIndex())
    }

<<<<<<< HEAD
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) return
        if (requestCode == REQUEST_CODE_CHEAT) {
            viewModel.setisCheater(true)
        }
    }

=======
>>>>>>> main
    private fun checkUserAnswer(userAnswer: Boolean) {
        if (viewModel.getQuestion().answer == userAnswer) Toast.makeText(
            this,
            R.string.correct_toast,
            Toast.LENGTH_SHORT
        ).show()
        else Toast.makeText(
            this,
            R.string.incorrect_toast, Toast.LENGTH_SHORT
        ).show()
    }


}