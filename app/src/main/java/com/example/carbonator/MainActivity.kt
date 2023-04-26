package com.example.carbonator

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.HttpResponse
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import okhttp3.Headers.Builder
import okhttp3.OkHttpClient
import okhttp3.internal.connection.ConnectInterceptor.intercept
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Request;
import okhttp3.Response;
import okio.IOException




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Authorization: Bearer <API_KEY>
        //val privateKey = "285K5KVXXC40TQH63M7B3Y82E1FJ"
        //Authorization: Bearer <API_KEY>
        getClimatiqData()

    }
//    private fun myHttpClient(): OkHttpClient {
//        val builder = OkHttpClient().newBuilder()
//            .addInterceptor(MyInterceptor())
//        return builder.build()
//    }
//
//    private val client = OkHttpClient()
//    private fun getClimatiqData() {
//        val request = Request.Builder()
//            .url("https://beta3.api.climatiq.io/estimate")
//            .header("Authorization", "Bearer: 285K5KVXXC40TQH63M7B3Y82E1FJ")
//            .build()
//
//        client.newCall(request).execute().use { response ->
//            if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//            println("Server: ${response.header("Server")}")
//            println("Date: ${response.header("Date")}")
//            println("Vary: ${response.headers("Vary")}")
//        }
//    }

    private fun getClimatiqData() {
        val client = AsyncHttpClient()
        client.addHeader('"Authorization", "Bearer $apiKey")

        //client.addHeader("Authorization", "Bearer: 285K5KVXXC40TQH63M7B3Y82E1FJ")
        val params = RequestParams()
        params.put("Authorization", "Bearer: 285K5KVXXC40TQH63M7B3Y82E1FJ")
        client["https://beta3.api.climatiq.io/estimate", object : JsonHttpResponseHandler()
        {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JSON
            ) {
                Log.d("Climatiq", "response successful")


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




