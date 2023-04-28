package com.example.carbonator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.codepath.asynchttpclient.RequestHeaders
import com.codepath.asynchttpclient.RequestParams
import okhttp3.Headers
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    var num: Double = 0.0
    data class carInfoPost(val postmake: String, val postmodel: String, val postyear: String, val postemission: String)
    private lateinit var carList: MutableList<String> //List of starting cars to send
    private lateinit var carListResults: MutableList<carInfoPost> //list of cars to send to RecyclerView
    private lateinit var rvCar: RecyclerView
    var make = ""
    var model = ""
    var year = ""
    var emission = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculationActivity = findViewById<Button>(R.id.button1)
        calculationActivity.setOnClickListener {
            val intent = Intent(this,Calculations::class.java) //you pass the class
            startActivity(intent)
        }
        //Creates the car list and populates it, using the API Call
        rvCar = findViewById(R.id.car_list)
        carListResults = mutableListOf()
        createCarList()
        for (i in 0 until carList.size) {
            getCO2e(i)
        }
        val co2e = findViewById<TextView>(R.id.co2e)
        co2e.setText(num.toString())
    }

    private fun getCO2e(i: Int) {
        val client = com.codepath.asynchttpclient.AsyncHttpClient()
        val url = "https://www.carboninterface.com/api/v1/estimates"
        val apiKey = "iVb1suaKPAAM8u0t0ApMQ"
        val carString = carList[i] //sends the particular car into the post request

        val requestHeaders = RequestHeaders()
        requestHeaders["Authorization"] = "Bearer iVb1suaKPAAM8u0t0ApMQ"
        requestHeaders["Content-Type"] = "application/json"


        val requestBody = """
    {
        "type": "vehicle",
        "distance_unit": "mi",
        "distance_value": 15000,
        "vehicle_model_id": "$carString"

    }
    """.trimIndent()

        val params = RequestParams()



        client.post(url, requestHeaders, params, requestBody, object : com.codepath.asynchttpclient.callback.JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: com.codepath.asynchttpclient.callback.JsonHttpResponseHandler.JSON
            ) {

                make = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getString("vehicle_make")
                make = "Make: " + make
                Log.d("make", make)
                model = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getString("vehicle_model")
                model = "Model: " + model
                Log.d("model", model)
                year = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getInt("vehicle_year").toString()
                year = "Year: " + year
                Log.d("year", year)
                emission = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getDouble("carbon_kg").toString()
                emission = "CO2 Emission: " + emission
                Log.d("emission", emission.toString())
                carListResults.add(carInfoPost(make, model, year, emission))

                //val adapter = CarAdapter(carListPost)
                rvCar.layoutManager = LinearLayoutManager(this@MainActivity)
                rvCar.adapter = CarAdapter(carListResults)

                //Log.d("Poke list", carListPost.toString())
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("co2e data error", errorResponse)
            }
        })
    }
    private fun createCarList() {
        carList = mutableListOf(
            "79d22090-4378-41b5-befc-79602216476e",
            "4edb1248-f0bc-4ed2-9b40-4592c9b1c287",
            "4d26cff2-0b7a-44e3-b416-3299f97bba4e",
            //"70c2fe22-6f3e-4f15-a3ca-839e70dfe8e9",
            //"e3ced1d5-f2ad-4baa-a9c2-e94a8d1fc280",

        )

    }
}
//"e6d9e81c-62e2-4cca-9173-407ae8c22624",
//"1d2e250f-01c4-4966-ad02-1f98380e9113",
//"4c979440-64f9-4c2e-9d8e-8800c9239044",
//"89f885e6-2016-4080-ad39-3396cd559f60",
//"286a9817-a619-44cb-ac78-c7a321c5867d",


