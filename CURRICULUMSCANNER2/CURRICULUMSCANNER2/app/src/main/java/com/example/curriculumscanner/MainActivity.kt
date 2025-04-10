package com.example.curriculumscanner

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val SITE_KEY = "6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"
    private var captchaPassed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val verifyButton = findViewById<Button>(R.id.buttonVerify)

        verifyButton.setOnClickListener {
            // Simulación de verificación CAPTCHA
            Toast.makeText(this, "✅ Verificación completada", Toast.LENGTH_SHORT).show()
            captchaPassed = true
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (!captchaPassed) {
                Toast.makeText(this, "Por favor verifica que no eres un robot", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email == "simonestebanc23@gmail.com" && password == "123456789") {
                val intent = Intent(this, TermsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
