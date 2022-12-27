package com.example.mommyjourneyapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NurseKeyInDetails : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>

    var databaseReference: DatabaseReference? = null
    var databases: FirebaseDatabase? = null
    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_nurse_key_in_details)


        userRecyclerview = findViewById(R.id.userlist2)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<Users>()
        getUserData()


    }


    @SuppressLint("SuspiciousIndentation")
    private fun getUserData() {
//
        dbref = FirebaseDatabase.getInstance().getReference("Users")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (userSnapshot in snapshot.children) {


                        val user = userSnapshot.getValue(Users::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = MyAdapter2(userArrayList)


                }

            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

      val btnDatePicker = findViewById(R.id.SelectDate) as Button
        btnDatePicker.setOnClickListener {

            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")
            datePicker.addOnPositiveButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)
                val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
                val date = dateFormatter.format(Date(it))
                Toast.makeText(applicationContext,"Selected date : " + date,Toast.LENGTH_LONG).show()
                databases = FirebaseDatabase.getInstance()
                databaseReference = databases?.reference!!.child("Users");
                auth = FirebaseAuth.getInstance()
                val currentUser = auth!!.currentUser

                val currentUSerDb = databaseReference?.child((currentUser?.uid!!))


                currentUSerDb?.child("CurrentAppointmentDate")?.setValue(date)


            }
            datePicker.addOnNegativeButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)

            }
            datePicker.addOnCancelListener {
                Log.d("DATEPICKER", "Date Picker Cancelled")
            }
        }


            val ViewPregnancyDetails = findViewById(R.id.next) as Button
            ViewPregnancyDetails.setOnClickListener {
                val intent = Intent(this, NurseKeyInUrineWeightBP::class.java)
                startActivity(intent)


            }
        }
    }


