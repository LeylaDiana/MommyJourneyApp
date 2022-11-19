package com.example.mommyjourneyapp


import android.content.Intent

import android.os.Bundle

import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.auth.FirebaseAuth



class PregnantMother : AppCompatActivity() {

    private var inputEmail: EditText? = null
    private var inputPassword: EditText? = null
    private var btnLogin: Button? = null


    private var auth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregnant_mother)

        setContentView(R.layout.activity_pregnant_mother)
        inputEmail = findViewById(R.id.email) as EditText
        inputPassword = findViewById(R.id.password) as EditText
        btnLogin = findViewById(R.id.login) as Button
        auth = FirebaseAuth.getInstance()

        btnLogin!!.setOnClickListener(View.OnClickListener {
            val email = inputEmail!!.text.toString().trim()
            val password = inputPassword!!.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Please Enter your email.", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(applicationContext, "Please Enter your Password", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }

            auth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->

                    if (!task.isSuccessful) {
                        if (password.length < 6) {
                            Toast.makeText(applicationContext, "Password Less Than 6", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(applicationContext, "Wrong Password", Toast.LENGTH_SHORT)
                                .show()

                                getString(R.string.auth_failed)

                        }
                    } else {
                        startActivity(Intent(this@PregnantMother, UserDashboard::class.java))
                        finish()
                    }
                }
        })

    }
}






