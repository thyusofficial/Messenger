package com.example.messenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()
            Log.d("Login", "Tentativa de login com e-mail e senha: $email/***")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                /*.addOnCompleteListener()
                .add*/
        }
        back_to_register_textview.setOnClickListener {
            finish()
        }
    }
}