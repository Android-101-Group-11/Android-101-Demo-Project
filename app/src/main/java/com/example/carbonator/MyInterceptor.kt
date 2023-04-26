package com.example.carbonator

import okhttp3.Interceptor
import okhttp3.Request;
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer: 285K5KVXXC40TQH63M7B3Y82E1FJ")
            //.url("https://beta3.api.climatiq.io/estimate")
            .build()
        return chain.proceed(request)

    }

}