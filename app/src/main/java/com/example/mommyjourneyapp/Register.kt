package com.example.mommyjourneyapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text


class Register : AppCompatActivity() {

    private var auth : FirebaseAuth?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register2)

//        add my code
        auth = FirebaseAuth.getInstance()


        var btnSignUp = findViewById(R.id.sign_in_button) as Button
        var inputEmail = findViewById(R.id.email) as EditText
        var inputPassword = findViewById(R.id.password) as EditText
        var progressBar = findViewById(R.id.progressBar) as ProgressBar




        btnSignUp!!.setOnClickListener(View.OnClickListener {
            val email = inputEmail!!.text.toString().trim()
            val password = inputPassword!!.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                Toast.makeText(applicationContext,"Enter your email Address!!", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(applicationContext,"Enter your Password",Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (password.length < 6){
                Toast.makeText(applicationContext,"Password too short, enter mimimum 6 charcters" , Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            progressBar!!.setVisibility(View.VISIBLE)

            //create user
            auth!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, OnCompleteListener {
                        task ->
                    Toast.makeText(this@Register,"createUserWithEmail:onComplete"+task.isSuccessful,Toast.LENGTH_SHORT).show()
                    progressBar!!.setVisibility(View.VISIBLE)

                    if (!task.isSuccessful){
                        Toast.makeText(this@Register,"User Not crated",Toast.LENGTH_SHORT).show()
                        return@OnCompleteListener
                    }else{
                        startActivity(Intent(this@Register, MainActivity::class.java))
                        finish()
                    }


                })

        })
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.progressBar)
        val progressBar = findViewById(R.id.progressBar) as ProgressBar
        progressBar!!.setVisibility(View.GONE)
    }
}








