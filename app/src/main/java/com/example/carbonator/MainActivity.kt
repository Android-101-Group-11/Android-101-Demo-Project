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


class MainActivity : AppCompatActivity() {
    var num: Double = 0.0
    data class carInfoPost(val postmake: String, val postmodel: String, val postyear: Int, val postemission: Int)
    private lateinit var carList: MutableList<String>
    private lateinit var carListPost: MutableList<carInfoPost>
    var make = ""
    var model = ""
    var year = 0
    var emission = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculationActivity = findViewById<Button>(R.id.button1)
        calculationActivity.setOnClickListener {
            val intent = Intent(this,Calculations::class.java) //you pass the class
            startActivity(intent)
        }
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
        val apiKey = "YcTh6ZXIQoTvQCCw1sew"
        val carString = carList[i]

        val requestHeaders = RequestHeaders()
        requestHeaders["Authorization"] = "Bearer YcTh6ZXIQoTvQCCw1sew"
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
                Log.d("make", make)
                model = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getString("vehicle_model")
                Log.d("model", model)
                year = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getInt("vehicle_year")
                Log.d("year", year.toString())
                emission = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getDouble("carbon_kg")
                Log.d("emission", emission.toString())
                //carListPost.add(carInfoPost(make, model, year, emission))

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
            "70c2fe22-6f3e-4f15-a3ca-839e70dfe8e9",
            "e3ced1d5-f2ad-4baa-a9c2-e94a8d1fc280",

        )

    }
}
//"e6d9e81c-62e2-4cca-9173-407ae8c22624",
//"1d2e250f-01c4-4966-ad02-1f98380e9113",
//"4c979440-64f9-4c2e-9d8e-8800c9239044",
//"89f885e6-2016-4080-ad39-3396cd559f60",
//"286a9817-a619-44cb-ac78-c7a321c5867d",


