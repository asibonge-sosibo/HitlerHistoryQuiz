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

        val textViewScore = findViewById<TextView>(R.id.textViewShowResult)
        val textViewPercentage = findViewById<TextView>(R.id.textView)
        val buttonFinish = findViewById<Button>(R.id.button)

        // Get score and feedback from intent
        val score = intent.getIntExtra("SCORE", 0)
        val feedback = intent.getStringExtra("FEEDBACK")

        // Calculate percentage
        val percentage = (score / 5.0) * 100

        // Show results
        textViewScore.text = "Score: $score / 5"
        textViewPercentage.text = "Percentage: ${percentage.toInt()}%\n$feedback"

        // Finish or restart
        buttonFinish.text = "Restart"
        buttonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
