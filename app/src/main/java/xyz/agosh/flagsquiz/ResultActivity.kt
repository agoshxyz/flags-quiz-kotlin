package xyz.agosh.flagsquiz

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name : TextView = findViewById(R.id.name)
        val trophyImage : ImageView = findViewById(R.id.trophyImage)
        val score : TextView = findViewById(R.id.score)
        val btnFinish : Button = findViewById(R.id.btnFinish)


            //trophyImage.setImageResource(vi)
        name.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        score.text = "Your score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}