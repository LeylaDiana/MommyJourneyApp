package com.example.mommyjourneyapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

class CreateNewAppoinment : AppCompatActivity() {


    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>

    var databaseReference: DatabaseReference? = null
    var databases: FirebaseDatabase? = null
    private var auth: FirebaseAuth? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_appoinment)
        val btnDatePicker = findViewById(R.id.CreateNewAppointment) as Button
        btnDatePicker.setOnClickListener {

            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")
            datePicker.addOnPositiveButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)
                val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
                val date = dateFormatter.format(Date(it))
                Toast.makeText(applicationContext,"Selected date : " + date, Toast.LENGTH_LONG).show()
                databases = FirebaseDatabase.getInstance()
                databaseReference = databases?.reference!!.child("Users");
                auth = FirebaseAuth.getInstance()
                val currentUser = auth!!.currentUser

                val currentUSerDb = databaseReference?.child((currentUser?.uid!!))


                currentUSerDb?.child("CreateNewAppointmentDate")?.setValue(date)


            }
            datePicker.addOnNegativeButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)

            }
            datePicker.addOnCancelListener {
                Log.d("DATEPICKER", "Date Picker Cancelled")
            }
        }




    }
}