package com.example.mommyjourneyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var textID: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textID = findViewById(R.id.textview)
        textID?.setText("MommyJourney")


        findViewById<TextView>(R.id.button2)
        val button2 = findViewById(R.id.button2) as Button
        button2.setOnClickListener {
            val intent = Intent(this, PregnantMother::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.button)
        val button = findViewById(R.id.button) as Button
        button.setOnClickListener {
            val intent = Intent(this, Nurse::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.NewUser)
        val NewUser = findViewById(R.id.NewUser) as TextView
        NewUser.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}










