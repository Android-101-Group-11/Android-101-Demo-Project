package com.example.carbonator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Calculations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculations)

        val back1 = findViewById<Button>(R.id.back)
        back1.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java) //you pass the class
            startActivity(intent2)


        }
    }
}