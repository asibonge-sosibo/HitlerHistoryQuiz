package vcmsa.asibonge.hitlerhistoryquiz

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.Gravity

class ActivityQuiz2 : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var radioTrue: RadioButton
    private lateinit var radioFalse: RadioButton
    private lateinit var buttonNext: Button
    private lateinit var feedbackText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioGroup = findViewById(R.id.RadioGroupQuestion2)
        radioTrue = findViewById(R.id.radioButtonTrueQuestion2)
        radioFalse = findViewById(R.id.radioButtonFalseQuestion2)
        buttonNext = findViewById(R.id.buttonNext)
        feedbackText = findViewById(R.id.textViewAnswerCorrectly)

        buttonNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId

            if (selectedId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            } else {
                val isCorrect = selectedId == R.id.radioButtonTrueQuestion2

                if (isCorrect) {
                    feedbackText.text = "Correct!"
                    val toast = Toast.makeText(this, "Correct answer!", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

                } else {
                    val toast = Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

                    val intent = Intent(this, ActivityQuiz3::class.java)
                    intent.putExtra("isCorrect", false)
                    startActivity(intent)
                }
            }
        }
    }
}
