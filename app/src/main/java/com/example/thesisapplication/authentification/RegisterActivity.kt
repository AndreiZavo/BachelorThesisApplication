package com.example.thesisapplication.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.thesisapplication.MainActivity
import com.example.thesisapplication.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerBtn = findViewById<Button>(R.id.signup_btn)
        val registerEmailField = findViewById<TextView>(R.id.email_signup)
        val registerPasswordField = findViewById<TextView>(R.id.password_signup)
        val registerConfirmPasswordField = findViewById<TextView>(R.id.confirm_password_signup)
        registerBtn.setOnClickListener {
            when{
                TextUtils.isEmpty(registerEmailField.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(registerPasswordField.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please insert a password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(registerConfirmPasswordField.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Please insert a password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email = registerEmailField.text.toString().trim { it <= ' ' }
                    val password = registerPasswordField.text.toString().trim { it <= ' ' }

                    // Create an instance and create a register a user with email and password
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                                if(task.isSuccessful) {
                                    // Firebase registered user
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this@RegisterActivity,
                                        "You are registered successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(this@RegisterActivity, MainActivity::class.java)
                                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                    intent.putExtra("email", email)
                                    startActivity(intent)
                                    finish()
                                } else{
                                    Toast.makeText(
                                        this@RegisterActivity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            })
                }
            }
        }
    }
}