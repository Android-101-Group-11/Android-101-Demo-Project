package com.example.carbonator

import com.example.carbonator.MyInterceptor
//import com.example.retrofittest.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://beta3.api.climatiq.io/estimate")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    val api: SimpleApi by lazy {
//        retrofit.create(SimpleApi::class.java)
//    }

}