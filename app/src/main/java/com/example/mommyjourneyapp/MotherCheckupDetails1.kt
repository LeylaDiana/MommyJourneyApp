package com.example.mommyjourneyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MotherCheckupDetails1 : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<Users>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pregnancy_checkup_mother_page_1)
        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.patientname)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@MotherCheckupDetails1,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

            userRecyclerview = findViewById(R.id.userList)
            userRecyclerview.layoutManager = LinearLayoutManager(this)
            userRecyclerview.setHasFixedSize(true)

            userArrayList = arrayListOf<Users>()
            getUserData()
        }

        findViewById<Button>(R.id.viewvideos)
        val MotherCheckupDetails1 = findViewById(R.id.viewvideos) as Button
        MotherCheckupDetails1.setOnClickListener {
            val intent = Intent(this, ChildBirthVideos::class.java)
            startActivity(intent)
        }

    }
    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Users")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (userSnapshot in snapshot.children) {


                        val user = userSnapshot.getValue(Users::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = MyAdapter(userArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}




