package com.example.carbonator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.loopj.android.http.AsyncHttpClient.log
import org.w3c.dom.Text

class Calculations : AppCompatActivity() {

    private var transportSelected : String = ""
    private var milesSelected : String = ""
    private lateinit var results : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculations)

        val back1 = findViewById<Button>(R.id.back)
        back1.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java) //you pass the class
            startActivity(intent2)
        }

        val calc2 = findViewById<Button>(R.id.calculate)
        val milesTravelled :Spinner = findViewById<Spinner>(R.id.miles)
        val transportSpinner : Spinner = findViewById<Spinner>(R.id.transportation)
      results  = findViewById(R.id.result)



            transportSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>,view: View?, position: Int, id: Long) {
                           transportSelected  = parent.getItemAtPosition(position).toString()
                    Log.d("Transport Selected", transportSelected)
                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {

                        }
                    }

        milesTravelled.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>, p1: View?, position: Int, p3: Long) {
                milesSelected   = p0.getItemAtPosition(position).toString()
                Log.d("Miles Selected", milesSelected)
                val emission = calculateEmission(transportSelected, milesSelected)
                results.text = "Emissions : $emission"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }
        calc2.setOnClickListener {
            val  emission = calculateEmission(transportSelected, milesSelected)
            results.text = "Emissions : $emission"
        }

    }

    private fun calculateEmission(transportSelected: String, milesSelected: String) : Double {
        var emission = 8.0
        when (transportSelected) {
            "Car" -> {
                when (milesSelected) {
                    """<2000""" -> emission = 100.0
                    "2,000 - 5,0000" -> emission = 200.0
                    "5,0000 – 10, 0000" -> emission = 300.0
                    """>10000""" -> emission = 400.0
                }
            }
            "Bus" -> {
                when (milesSelected) {
                    """<2000""" -> emission = 100.0
                    "2,000 - 5,0000" -> emission = 200.0
                    "5,0000 – 10, 0000" -> emission = 300.0
                    """>10000""" -> emission = 400.0
                }
            }
            "Train" -> {
                when (milesSelected) {
                    """<2000""" -> emission = 100.0
                    "2,000 - 5,0000" -> emission = 200.0
                    "5,0000 – 10, 0000" -> emission = 300.0
                    """>10000""" -> emission = 400.0
                }
            }

            "Plane" -> {
                when (milesSelected) {
                    """<2000""" -> emission = 100.0
                    "2,000 - 5,0000" -> emission = 200.0
                    "5,0000 – 10, 0000" -> emission = 300.0
                    """>10000""" -> emission = 400.0
                }
            }
            // a
        }
        return emission
    }


}