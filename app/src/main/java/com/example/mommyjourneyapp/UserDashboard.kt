package com.example.mommyjourneyapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.cardview.widget.CardView

class UserDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf( "Marsita Adlina Abdul Rahman", "590216085238", "16/02/1959", "0122136137" )

        // access the listView from xml file
        val mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter
        mListView.setBackgroundColor(Color.parseColor("#E7E0EC"));

    }
}
