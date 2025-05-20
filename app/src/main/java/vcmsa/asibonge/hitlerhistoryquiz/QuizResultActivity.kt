package vcmsa.asibonge.hitlerhistoryquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class scoreScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val scoreText = findViewById<TextView>(R.id.textViewShowResult)
        val feedbackMsg = findViewById<TextView>(R.id.FeedBack)
        val exitBtn = findViewById<Button>(R.id.ExitButton)
        val reviewBtn = findViewById<Button>(R.id.showButton)

        val score = intent.getIntExtra("SCORE", 0)
        val feedback = intent.getStringExtra("FEEDBACK") ?: "No feedback available."

        scoreText.text = "Your Score: $score / 5"
        feedbackMsg.text = feedback

        exitBtn.setOnClickListener {
            finishAffinity()
        }

        reviewBtn.setOnClickListener {
            Toast.makeText(this, "Review feature coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}

