package com.example.mommyjourneyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Nurse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurse)

        findViewById<TextView>(R.id.btnSSigned)
        val button = findViewById(R.id.btnSSigned) as Button
        button.setOnClickListener {
            val intent = Intent(this, NurseKeyInDetails::class.java)
            startActivity(intent)
        }
    }
}