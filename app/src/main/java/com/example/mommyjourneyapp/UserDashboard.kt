package com.example.mommyjourneyapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class UserDashboard : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>
    var databaseReference: DatabaseReference? = null
    var databases: FirebaseDatabase? = null
    private var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)


        findViewById<ImageView>(R.id.MotherPhoto)






       val fireBaseTextView2 = findViewById<View>(R.id.date1)

        //Write a message to the database

        //Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Users").child("CurrentAppointmentDate").toString()




//






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





