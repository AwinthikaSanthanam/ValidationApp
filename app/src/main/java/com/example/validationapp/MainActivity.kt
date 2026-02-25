package com.example.validationapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etId: EditText
    lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link UI components
        etUsername = findViewById(R.id.etUsername)
        etId = findViewById(R.id.etId)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {

        val username = etUsername.text.toString().trim()
        val id = etId.text.toString().trim()

        // 1️⃣ Check empty fields
        if (username.isEmpty() || id.isEmpty()) {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        // 2️⃣ Username alphabets only
        if (!username.matches(Regex("^[a-zA-Z]+$"))) {
            etUsername.error = "Name should contain alphabets only"
            return
        }

        // 3️⃣ ID must be exactly 4 digits
        if (!id.matches(Regex("^\\d{4}$"))) {
            etId.error = "ID must be exactly 4 digits"
            return
        }

        // Success message
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()
    }
}