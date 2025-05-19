package vcmsa.asibonge.hitlerhistoryquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizResultActivity : AppCompatActivity() {

    private lateinit var textViewShowResult: TextView
    private lateinit var buttonReturn: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_result)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textViewShowResult = findViewById(R.id.textViewShowResult)
        buttonReturn = findViewById(R.id.button)

        val isCorrect = intent.getBooleanExtra("isCorrect", false)

        if (isCorrect) {
            textViewShowResult.text = "🎉 Congratulations! You answered correctly."
        } else {
            textViewShowResult.text = "❌ Oops! That's not the right answer."
        }

        buttonReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
