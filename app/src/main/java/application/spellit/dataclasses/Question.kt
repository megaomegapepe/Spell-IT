package application.spellit.dataclasses

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean)
