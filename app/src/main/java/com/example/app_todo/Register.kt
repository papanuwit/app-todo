package com.example.app_todo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_todo.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonRegiaster = findViewById<Button>(R.id.button_register)

        buttonRegiaster.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }


}