package com.example.messenger

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            val email = getString("EMAIL", "")
            val password = getString("PASSWORD", "")
            email_edittext_login.setText(email)
            password_edittext_login.setText(password)
        }

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
    fun saveData(v: View){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor
            .putString("EMAIL", email_edittext_login.text.toString())
            .putString("PASSWORD", password_edittext_login.text.toString())
            .apply()
        val toast = Toast.makeText(applicationContext, "Dados salvos!", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 1100)
        toast.show()
    }
}