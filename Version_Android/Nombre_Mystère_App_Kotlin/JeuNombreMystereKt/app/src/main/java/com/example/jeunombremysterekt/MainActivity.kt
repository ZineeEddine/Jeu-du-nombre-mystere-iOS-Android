package com.example.jeunombremysterekt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boutton_jouer = findViewById<Button>(R.id.button_jouer)
        boutton_jouer.setOnClickListener{
            openActivity_jeu()
        }

        val boutton_quitter = findViewById<Button>(R.id.button_quitter)
        boutton_quitter.setOnClickListener{
            quitterApp()
        }
    }

    fun openActivity_jeu() {
        val intent = Intent(this, Jeu_Activity::class.java)
        startActivity(intent)
    }

    fun quitterApp() {
        System.exit(0)
    }
}