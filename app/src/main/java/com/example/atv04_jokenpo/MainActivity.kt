package com.example.atv04_jokenpo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var botaoJogar: ImageButton
    lateinit var botaoRegras: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botaoRegras = findViewById(R.id.botaoRegras)
        botaoJogar = findViewById(R.id.botaoJogar)

        botaoRegras.setOnClickListener {

            val intent = Intent(applicationContext, Regras::class.java)

            startActivity(intent)
        }

        botaoJogar.setOnClickListener {

            val intent = Intent(applicationContext, Jogar2::class.java)

            startActivity(intent)
        }

    }
}