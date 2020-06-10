package com.example.module_network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * http://data.live.126.net/
 */
object ServiceCreator2 {
    private val builder = Retrofit.Builder()
        .baseUrl("http://data.live.126.net/")
        .addConverterFactory(GsonConverterFactory.create())



    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}