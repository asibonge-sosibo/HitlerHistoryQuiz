package vcmsa.asibonge.hitlerhistoryquiz

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ActivityQuiz1 : AppCompatActivity() {

    private var counter = 0
    private val HitlerHistoryQuiz = arrayOf(
        "Hitler was born in Germany.",
        "Hitler wrote a book called Mein Kampf while in prison.",
        "Adolf Hitler became Chancellor of Germany in 1933.",
        "Hitler led the Communist Party in Germany.",
        "World War II ended with Hitler’s surrender in 1945. "
    )

    private val answerChoices = arrayOf(
        arrayOf("True", "False"),
        arrayOf("True", "False"),
        arrayOf("True", "False"),
        arrayOf("True", "False"),
        arrayOf("True", "False")
    )
    private val correctAnswers = arrayOf("False", "True", "True", "False", "False")
    private val userAnswer = arrayOfNulls<String>(5)

    override fun onCreat(savedInstanceState:Bundle){
        super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quiz1)

        val Question = findViewById<TextView>(R.id.Question)
        val buttonNext = findViewById<RadioGroup>(R.id.radioButtonTrue)
        val buttonNext = findViewById<Button>(R.id.buttonNext)

        val displayQuestion = Unit
        displayQuestion
    }
}
