package application.spellit.viewmodels

import androidx.lifecycle.ViewModel
import application.spellit.R
import application.spellit.dataclasses.Question

class MainActivityViewModel : ViewModel() {

    private var currentIndexOfQuestion = 0
    private var isCheater = false

    private val questions = listOf(
        Question(R.string.first_question, true),
        Question(R.string.second_question, true)
    )

    fun getQuestion(): Question {
        return questions[currentIndexOfQuestion]
    }

    //Increment an index of questions
    fun nextQuestion() {
        currentIndexOfQuestion = (currentIndexOfQuestion + 1) % questions.size
    }

    fun getCurrentIndex(): Int {
        return currentIndexOfQuestion
    }

    fun setCurrentIndex(index: Int) {
        this.currentIndexOfQuestion = index
    }

    fun setisCheater(isCheater: Boolean) {
        this.isCheater = isCheater
    }

    fun getIsCheater(): Boolean {
        return this.isCheater
    }


}