package com.example.mommyjourneyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PregnantMother : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregnant_mother)

        findViewById<TextView>(R.id.button4)
        val button = findViewById(R.id.button4) as Button
        button.setOnClickListener {
            val intent = Intent(this, UserDashboard::class.java)
            startActivity(intent)
        }
    }
}