package vcmsa.asibonge.hitlerhistoryquiz

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityQuiz1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        class ActivityQuiz1 : AppCompatActivity() {

            private lateinit var radioGroup: RadioGroup
            private lateinit var radioTrue: RadioButton
            private lateinit var radioFalse: RadioButton
            private lateinit var buttonNext: Button
            private lateinit var questionFeedback: TextView

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_quiz1)

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }
                radioGroup = findViewById(R.id.RadioGroupQuestion1)
                radioTrue = findViewById(R.id.radioButtonTrueQuiz1)
                radioFalse = findViewById(R.id.radioButtonFalseQuiz1)
                buttonNext = findViewById(R.id.buttonNext)
                questionFeedback = findViewById(R.id.TextViewQuizTime)

                buttonNext.setOnClickListener {
                    val selectedId = radioGroup.checkedRadioButtonId

                    if (selectedId == -1) {
                        Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                    } else {
                        val isCorrect = selectedId == R.id.radioButtonFalseQuiz1
                        if (isCorrect) {
                            questionFeedback.text = "Correct!"
                            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show()
                            // TODO: Start next activity if you have another question
                        } else {
                            questionFeedback.text = "Incorrect!"
                            Toast.makeText(this, "Wrong answer. Try again!", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
}