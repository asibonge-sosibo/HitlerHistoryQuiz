package vcmsa.asibonge.hitlerhistoryquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("UNREACHABLE_CODE")
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz1)

        val Question = findViewById<TextView>(R.id.Question)
        val radioGroupQuestion = findViewById<RadioGroup>(R.id.RadioGroupQuestion)
        val buttonNext = findViewById<Button>(R.id.buttonNext)

        displayQuestion(Question, radioGroupQuestion)

        buttonNext.setOnClickListener {
            val selectedId = radioGroupQuestion.checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                userAnswer[counter] = selectedRadioButton.text.toString()
                counter++

                if (counter < HitlerHistoryQuiz.size) {
                    displayQuestion(Question, radioGroupQuestion)
                } else {
                    val score = calculateScore()
                    val feedback = when {
                        score == 5 -> "Great work!"
                        score >= 3 -> "Not bad, do better next time!"
                        else -> "Try again!"
                    }

                    val intent = Intent(this, activityResultRegistry::class.java)
                    intent.putExtra("SCORE", score)
                    intent.putExtra("FEEDBACK", feedback)
                    startActivity(intent)
                    finish()
                }
            } else {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun displayQuestion(tvQuestion: TextView, rbtngAnswers: RadioGroup) {
        tvQuestion.text = HitlerHistoryQuiz[counter]
        rbtngAnswers.clearCheck()

        for (i in 0 until rbtngAnswers.childCount) {
            val radioButton = rbtngAnswers.getChildAt(i) as RadioButton
            radioButton.text = answerChoices[counter][i]
        }
    }

    private fun calculateScore(): Int {
        var score = 0
        for (i in correctAnswers.indices) {
            if (userAnswer[i] == correctAnswers[i]) {
                score++
            }
        }
        return score
        val intent = Intent(this, QuizResultActivity::class.java)
        startActivity(intent)
        finish()
    }

    }

