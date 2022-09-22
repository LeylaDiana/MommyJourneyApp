package com.example.mommyjourneyapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class UserDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)
        var arrayAdapter: ArrayAdapter<*>
        val users = arrayOf( "Name : Megan Fox", "IC Number : 000726997275", " Date of Birth : 16/05/1986", " Handphone Number : 0126666912" )
        val  followup = arrayOf( "Follow Up", "Follow Up ",  "Follow Up"  )
        val  date = arrayOf( "26/07/2022", "27/5/2022","25/03/1995"
        )

        val uListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        uListView.adapter = arrayAdapter
        uListView.setBackgroundColor(Color.parseColor("#E7E0EC"));


        // access the listView from xml file
        val ListView = findViewById<ListView>(R.id.followup)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, followup)
        ListView.adapter = arrayAdapter
        ListView.setBackgroundColor(Color.parseColor("#E7E0EC"));
        
        val mListView = findViewById<ListView>(R.id.date)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, date)
        mListView.adapter = arrayAdapter
        mListView.setBackgroundColor(Color.parseColor("#E7E0EC"));

        findViewById<TextView>(R.id.ViewPregnancyDetails)
        val ViewPregnancyDetails = findViewById(R.id.ViewPregnancyDetails) as TextView
        ViewPregnancyDetails.setOnClickListener {
            val intent = Intent(this, MotherCheckupDetails1::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.babykickicon)
        val babykickicon = findViewById(R.id.babykickicon) as ImageView
        babykickicon.setOnClickListener {
            val intent = Intent(this, BabyKickCounter::class.java)
            startActivity(intent)
        }

    }
}
