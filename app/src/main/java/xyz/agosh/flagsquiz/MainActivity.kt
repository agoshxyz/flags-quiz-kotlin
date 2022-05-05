package xyz.agosh.flagsquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnStart: Button = findViewById(R.id.btnStart)
        val name: EditText = findViewById(R.id.name)
        btnStart.setOnClickListener {
            if (name.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            } else if (name.text.length < 3 || name.text.length > 20) {
                Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_LONG).show()
            }
            else if(name.text.isDigitsOnly()){
                Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_LONG).show()
            }
            else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name.text.toString())
                startActivity(intent)
                finish()
            }


        }
    }
}