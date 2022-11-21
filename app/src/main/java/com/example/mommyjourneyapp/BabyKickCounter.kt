package com.example.mommyjourneyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class BabyKickCounter : AppCompatActivity() {
    private lateinit var counter_txt : TextView
    private lateinit var BabyKickIcon : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baby_kick_counter)

        counter_txt = findViewById(R.id.counter_txt)
        BabyKickIcon = findViewById(R.id.BabyKickIcon)

        var timesClicked = 0


        BabyKickIcon.setOnClickListener{
            timesClicked += 1

          counter_txt.text = timesClicked.toString()
        }

    }
}
