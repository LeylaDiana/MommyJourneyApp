package com.example.mommyjourneyapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class UserDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)


        findViewById<ImageView>(R.id.MotherPhoto)



//        var arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf( "Name:".toString(),
//            "IC Number: ",
//            " Date of Birth: ",
//            "Hospital Name: ")
//
//
//        val  followup = arrayOf( "Follow Up", "Follow Up ",  "Follow Up"  )
//        val  date = arrayOf( "26/07/2022", "27/5/2022","25/03/1995"
//        )
//
//        val uListView = findViewById<ListView>(R.id.userlist)
//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
//        uListView.adapter = arrayAdapter
//        uListView.setBackgroundColor(Color.parseColor("#E7E0EC"));
//
//
//        // access the listView from xml file
//        val ListView = findViewById<ListView>(R.id.followup)
//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, followup)
//        ListView.adapter = arrayAdapter
//        ListView.setBackgroundColor(Color.parseColor("#E7E0EC"));
//
//        val mListView = findViewById<ListView>(R.id.date)
//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, date)
//        mListView.adapter = arrayAdapter
//        mListView.setBackgroundColor(Color.parseColor("#E7E0EC"));

        findViewById<Button>(R.id.viewpreg)
        val ViewPregnancyDetails = findViewById(R.id.viewpreg) as Button
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

