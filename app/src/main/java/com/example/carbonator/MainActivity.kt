package com.example.carbonator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< Updated upstream
=======

        //to go to the next activity/page
        val calculationActivity = findViewById<Button>(R.id.button1)
        calculationActivity.setOnClickListener {
            val intent = Intent(this,Calculations::class.java) //you pass the class
            startActivity(intent)
        }
//<<<<<<< Updated upstream
        getCO2e()
        val co2e = findViewById<TextView>(R.id.co2e)
        co2e.setText(num.toString())
>>>>>>> Stashed changes
    }
}