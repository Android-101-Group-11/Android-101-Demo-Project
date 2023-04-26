package com.example.carbonator

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Authorization: Bearer <API_KEY>
        //val privateKey = "285K5KVXXC40TQH63M7B3Y82E1FJ"
        //val authorizationheaders = {"Authorization": f"Bearer: {$privateKey}"}
        //Authorization: Bearer <API_KEY>
        //var responseHeaders = addHeader()



    }
    public fun addHeader("Authorization", "$privateKey")

    private fun getClimatiqData() {
        val client = AsyncHttpClient()
        client["https://beta3.api.climatiq.io/estimate", object : JsonHttpResponseHandler()
        {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {

            }
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Climatiq data error", errorResponse)
            }
        }]
    }
}