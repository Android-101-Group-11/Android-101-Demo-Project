package com.example.carbonator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import com.codepath.asynchttpclient.RequestHeaders
import com.codepath.asynchttpclient.RequestParams
import okhttp3.FormBody

import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var num: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCO2e()
        val co2e = findViewById<TextView>(R.id.co2e)
        co2e.setText(num.toString())
    }

    private fun getCO2e() {
        val client = com.codepath.asynchttpclient.AsyncHttpClient()
        val url = "https://www.carboninterface.com/api/v1/estimates"
        val apiKey = "YcTh6ZXIQoTvQCCw1sew"

        val requestHeaders = RequestHeaders()
        requestHeaders["Authorization"] = "Bearer YcTh6ZXIQoTvQCCw1sew"
        requestHeaders["Content-Type"] = "application/json"


        val requestBody = """
    {
        "type": "electricity",
        "electricity_unit": "mwh",
        "electricity_value": 42,
        "country": "us",
        "state": "fl"
    }
    """.trimIndent()

        val params = RequestParams()



        client.post(url, requestHeaders, params, requestBody, object : com.codepath.asynchttpclient.callback.JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: com.codepath.asynchttpclient.callback.JsonHttpResponseHandler.JSON
            ) {
                num = json.jsonObject.getJSONObject("data").getJSONObject("attributes").getDouble("carbon_kg")
                Log.d("co2e", "response successful")
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

}




