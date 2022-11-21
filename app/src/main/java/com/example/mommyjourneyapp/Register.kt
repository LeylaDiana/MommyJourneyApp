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

    private var auth: FirebaseAuth? = null
    private lateinit var button: Button
    private lateinit var imageView: ImageView


        val IMAGE_REQUEST_CODE = 100



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register2)

//        add my code
        auth = FirebaseAuth.getInstance()
         button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)

        button.setOnClickListener{
            pickImageGallery()

        }


        var btnSignUp = findViewById(R.id.sign_in_button) as Button
        var inputEmail = findViewById(R.id.email) as EditText
        var inputPassword = findViewById(R.id.password) as EditText





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


            //create user
            auth!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, OnCompleteListener {
                        task ->
                    Toast.makeText(this@Register,"createUserWithEmail:onComplete"+task.isSuccessful,Toast.LENGTH_SHORT).show()


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

    private fun pickImageGallery (){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            imageView.setImageURI(data?.data)
        }
    }

}








