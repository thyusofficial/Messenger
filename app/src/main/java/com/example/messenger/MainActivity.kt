package com.example.messenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener {
            performRegister()
        }
        have_account_text_view.setOnClickListener {
            Log.d("MainActivity", "Tenta mostrar a activity de login")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performRegister(){
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Insira um email e password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "Email é: " + email)
        Log.d("MainActivity", "Password é:  $password")
        //Firebase Auth para criar usuário com email e senha
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful) return@addOnCompleteListener

                //else se for success
                Log.d("Main", "Usuário criado com sucesso com uid: ${it.result.user.uid}")
            }
            .addOnFailureListener{
                Log.d("Main","Falha ao criar a conta: ${it.message}")
                Toast.makeText(this, "Falha ao criar a conta: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
