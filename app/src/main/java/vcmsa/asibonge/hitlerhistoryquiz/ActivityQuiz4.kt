package vcmsa.asibonge.hitlerhistoryquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityQuiz4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        class ActivityQuiz4 : AppCompatActivity() {

            private lateinit var radioGroup: RadioGroup
            private lateinit var radioTrue: RadioButton
            private lateinit var radioFalse: RadioButton
            private lateinit var buttonNext: Button
            private lateinit var feedbackText: TextView

            @SuppressLint("SetTextI18n")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_quiz4)

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }

                radioGroup = findViewById(R.id.RadioGroupQuestion4)
                radioTrue = findViewById(R.id.radioButtonTrueQuiz4)
                radioFalse = findViewById(R.id.radioButtonFalseQuiz4)
                buttonNext = findViewById(R.id.buttonNext)
                feedbackText = findViewById(R.id.TextViewAlmostThere)

                buttonNext.setOnClickListener {
                    val selectedId = radioGroup.checkedRadioButtonId

                    if (selectedId == -1) {
                        Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                    } else {
                        val isCorrect = selectedId == R.id.radioButtonFalseQuiz4
                        if (isCorrect) {
                            feedbackText.text = "Correct!"
                            Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, ActivityQuiz5::class.java)
                            startActivity(intent)
                        } else {
                        }
                    }
                }
            }
        }

    }
}