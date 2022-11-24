package com.example.mommyjourneyapp


import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class Register : AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    private lateinit var button: Button
    private lateinit var imageView: ImageView
    var databaseReference :  DatabaseReference? = null
    var databases: FirebaseDatabase? = null


    val IMAGE_REQUEST_CODE = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register2)
//        add my code
        auth = FirebaseAuth.getInstance()
        button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageView)
         databases = FirebaseDatabase.getInstance()
        databaseReference = databases?.reference!!.child("Users");
        
        button.setOnClickListener{
            pickImageGallery()

        }


        val btnSignUp = findViewById(R.id.sign_in_button) as Button
        val inputEmail = findViewById(R.id.emailregister) as EditText
        val inputPassword = findViewById(R.id.passwordregister) as EditText
        val inputFullName = findViewById(R.id.fullName) as EditText
        val inputDate = findViewById(R.id.date) as EditText
        val inputiCNo = findViewById(R.id.iCNo) as EditText




        btnSignUp!!.setOnClickListener(View.OnClickListener {
            var fullName = inputFullName!!.text.toString().trim()
            var date = inputDate!!.text.toString().trim()
            var iCNo= inputiCNo!!.text.toString().trim()
            var email = inputEmail!!.text.toString().trim()
            var password = inputPassword!!.text.toString().trim()


            if (TextUtils.isEmpty(email)){
                Toast.makeText(applicationContext,"Enter your email Address!!", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(applicationContext,"Enter your Password",Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(fullName)){
                Toast.makeText(applicationContext,"Enter your Full Name",Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(date)){
                Toast.makeText(applicationContext,"Enter your Birthdate",Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(iCNo)){
                Toast.makeText(applicationContext,"Enter your IC NO",Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            if (password.length < 6){
                Toast.makeText(applicationContext,"Password too short, enter mimimum 6 charcters, include letters" , Toast.LENGTH_LONG).show()
                return@OnClickListener
            }


            //create user
            auth!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, OnCompleteListener {
                        task ->
                    val currentUser = auth!!.currentUser

                    val currentUSerDb = databaseReference?.child((currentUser?.uid!!))
                    Toast.makeText(this@Register,"createUserWithEmail:onComplete"+task.isSuccessful,Toast.LENGTH_SHORT).show()

                    currentUSerDb?.child("Full Name")?.setValue(inputFullName.text.toString())
                    currentUSerDb?.child("Birthdate")?.setValue(inputDate.text.toString())
                    currentUSerDb?.child("IC NO")?.setValue(inputiCNo.text.toString())
                    currentUSerDb?.child("Email")?.setValue(inputEmail.text.toString())
                    currentUSerDb?.child("Password")?.setValue(inputPassword.text.toString())

                    if (!task.isSuccessful){
                        Toast.makeText(this@Register,"User Not created",Toast.LENGTH_SHORT).show()
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








