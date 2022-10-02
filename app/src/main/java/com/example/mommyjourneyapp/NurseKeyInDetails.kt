package com.example.mommyjourneyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class NurseKeyInDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurse_key_in_details)


        val patientname = resources.getStringArray(R.array.PatientName)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.patientname)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, patientname
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@NurseKeyInDetails,
                        getString(R.string.selected_patient) + " " +
                                "" + patientname[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }


            findViewById<TextView>(R.id.next)
            val ViewPregnancyDetails = findViewById(R.id.next) as Button
            ViewPregnancyDetails.setOnClickListener {
                val intent = Intent(this, NurseKeyInUrineWeightBP::class.java)
                startActivity(intent)


            }
        }
    }
}
