package com.example.mommyjourneyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NurseKeyInUrineWeightBP : AppCompatActivity() {
    private var auth: FirebaseAuth? = null

    private lateinit var save: Button

    var databaseReference: DatabaseReference? = null
    var databases: FirebaseDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurse_key_in_urine_weight_bp)

        auth = FirebaseAuth.getInstance()
        save = findViewById(R.id.savebtn)

        databases = FirebaseDatabase.getInstance()
        databaseReference = databases?.reference!!.child("PregnancyDetailsSelectedUser");


        val urinecolor = resources.getStringArray(R.array.UrineColor)
        val bplevel = resources.getStringArray(R.array.BPLevel)
        val spinner = findViewById<Spinner>(R.id.urinecolor)

        val save = findViewById(R.id.savebtn) as Button
        val inputWeight= findViewById(R.id.WeightEdit) as EditText
        val inputHeight = findViewById(R.id.HeightEdit) as EditText
        save!!.setOnClickListener(View.OnClickListener {

            var weight = inputWeight!!.text.toString().trim()
            var height = inputHeight!!.text.toString().trim()

            if (TextUtils.isEmpty(weight)) {
                Toast.makeText(applicationContext, "Enter your weight", Toast.LENGTH_LONG)
                    .show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(height)) {
                Toast.makeText(applicationContext, "Enter your height", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            if (spinner != null) {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, urinecolor
                )
                spinner.adapter = adapter

                spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        Toast.makeText(
                            this@NurseKeyInUrineWeightBP,
                            getString(R.string.selected_urinecolor) + " " +
                                    "" + urinecolor[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action
                    }
                }


                // access the spinner
                val spinner = findViewById<Spinner>(R.id.bplevel)
                if (spinner != null) {
                    val adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item, bplevel
                    )
                    spinner.adapter = adapter

                    spinner.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View, position: Int, id: Long
                        ) {
                            Toast.makeText(
                                this@NurseKeyInUrineWeightBP,
                                getString(R.string.selected_bplevel) + " " +
                                        "" + bplevel[position], Toast.LENGTH_SHORT
                            ).show()
                        }

                        override fun onNothingSelected(parent: AdapterView<*>) {

                        }
                    }
                }
            }

                    val currentUser = auth!!.currentUser

                    val currentUSerDb = databaseReference?.child((currentUser?.uid!!))

                    Toast.makeText(
                        this@NurseKeyInUrineWeightBP,
                        "SavePregnantUserData:onComplete" ,
                        Toast.LENGTH_SHORT
                    ).show()

                    currentUSerDb?.child("Urine Color")?.setValue(getString(R.string.selected_urinecolor))
                    currentUSerDb?.child("Weight")?.setValue(inputWeight.text.toString())
                    currentUSerDb?.child("Height")?.setValue(inputHeight.text.toString())
                    currentUSerDb?.child("BPLevel")?.setValue(getString(R.string.selected_bplevel))




                })
        }
    }

