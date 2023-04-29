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
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.roundToInt

class Calculations : AppCompatActivity() {

    private var transportSelected: String = ""
    private var milesSelected: String = ""
    private lateinit var results: TextView
    private val camry : Double = 2.58
    private val tesla : Double = 0.87
    private val tacoma : Double = 3.35
    private val ford : Double = 3.72
    private val chevy : Double = 3.86
    private val rav4 : Double = 2.31
    private val rover : Double = 3.72
    private val jeep : Double = 3.35
    private val leaf : Double = 0.99
    private val oneMile : Double = 6.21371




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculations)

        val back1 = findViewById<Button>(R.id.back)
        back1.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java) //you pass the class
            startActivity(intent2)
        }

        val calc2 = findViewById<Button>(R.id.calculate)
        val milesTravelled: Spinner = findViewById(R.id.miles)
        val transportSpinner: Spinner = findViewById(R.id.transportation)
        val funFact : TextView = findViewById(R.id.funFact)
        results = findViewById(R.id.result)


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
               // val emission = calculateEmission(transportSelected, milesSelected)
                //results.text = "Emissions : $emission"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }


        }
        calc2.setOnClickListener {
            val  emission = calculateEmission(transportSelected, milesSelected)
            val roundedEmission  = (emission * 50).roundToInt() / 50.0
            funFact.visibility = View.INVISIBLE
            results.visibility = View.VISIBLE
            results.text = "Emissions : $roundedEmission" + " Kg"
        }

    }

    private fun calculateEmission(transportSelected: String, milesSelected: String) : Double {
        val lessThan2000 = 1000
        var emission = 0.0
        when (transportSelected) {
            "Toyota Camry" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (camry / oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (camry / oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (camry / oneMile)
                    "More than 10,000" -> emission = 50000 * (camry / oneMile)
                }
            }
            "Tesla Model Y" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (tesla/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (tesla/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (tesla/oneMile)
                    "More than 10,000"-> emission = 50000 * (tesla/oneMile)
                }
            }
            "Toyota Tacoma" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (tacoma/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (tacoma/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (tacoma/oneMile)
                    "More than 10,000"-> emission = 50000 * (tacoma/oneMile)
                }
            }

            "Ford F-Series" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (ford/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (ford/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (ford/oneMile)
                    "More than 10,000"-> emission = 50000 * (ford/oneMile)
                }
            }

            "Chevy Silverado" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (chevy/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (chevy/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (chevy/oneMile)
                    "More than 10,000"-> emission = 50000 * (chevy/oneMile)
                }
            }


            "Land Rover Range Rover" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (rover/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (rover/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (rover/oneMile)
                    "More than 10,000"-> emission = 50000 * (rover/oneMile)
                }
            }

            "Nissan Leaf" -> { //left
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (leaf/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (leaf/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (leaf/oneMile)
                    "More than 10,000"-> emission = 50000 * (leaf/oneMile)
                }
            }

            "Jeep Grand Cherokee" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (jeep/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (jeep/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (jeep/oneMile)
                    "More than 10,000"-> emission = 50000 * (jeep/oneMile)
                }
            }

            "Toyota RAV4" -> {
                when (milesSelected) {
                    "Less than 2000" -> emission = lessThan2000 * (rav4/oneMile)
                    "2,000 - 5,0000" -> emission = 4500 * (rav4/oneMile)
                    "5,0000 – 10, 0000" -> emission = 12500 * (rav4/oneMile)
                    "More than 10,000"-> emission = 50000 * (rav4/oneMile)
                }
            }



            // a
        }
        return emission
    }


    }
