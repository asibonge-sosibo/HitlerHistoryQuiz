package vcmsa.asibonge.hitlerhistoryquiz

import android.content.Intent
import androidx.activity.enableEdgeToEdge
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityQuiz5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        class ActivityQuiz5 : AppCompatActivity() {

            private lateinit var radioGroup: RadioGroup
            private lateinit var radioTrue: RadioButton
            private lateinit var radioFalse: RadioButton
            private lateinit var buttonNext: Button

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_quiz5)


                radioGroup = findViewById(R.id.RadioGroupQuestion5)
                radioTrue = findViewById(R.id.radioButtonTrueQuiz5)
                radioFalse = findViewById(R.id.radioButtonFalseQuiz5)
                buttonNext = findViewById(R.id.buttonNext)


                buttonNext.setOnClickListener {
                    val selectedId = radioGroup.checkedRadioButtonId

                    if (selectedId == -1) {
                        Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                    } else {
                        val isCorrect = selectedId == R.id.radioButtonFalseQuiz5

                        if (isCorrect) {
                            Toast.makeText(this, "Correct! Hitler did not surrender; Germany did.", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Incorrect. Germany surrendered in 1945 after Hitler's death.", Toast.LENGTH_LONG).show()
                        }


                        val intent = Intent(this, QuizResultActivity::class.java)
                        intent.putExtra("isCorrect", isCorrect)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

    }
}