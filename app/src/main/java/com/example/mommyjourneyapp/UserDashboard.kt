package com.example.mommyjourneyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class UserDashboard : AppCompatActivity() {
    val fruits = arrayOf("Apple","Banana","PinaApple","Mango","Orange" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)
        val listView = findViewById<ListView>(R.id.list)



    }
}