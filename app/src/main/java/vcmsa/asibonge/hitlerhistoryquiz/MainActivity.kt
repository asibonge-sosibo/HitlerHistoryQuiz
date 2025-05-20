package vcmsa.asibonge.hitlerhistoryquiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
@SuppressLint("MissingInflatedID", "WrongViewCast")
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
    val editTextName = findViewById<EditText>(R.id.editTextName)
    val buttonNext = findViewById<Button>(R.id.buttonNext)

    val name = editTextName.text.toString()
    buttonNext.setOnClickListener {
        val intent = Intent(this, ActivityQuiz1::class.java).putExtra("Name",name)
        startActivity(intent)

            }
        }
    }

