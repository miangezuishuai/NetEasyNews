package com.example.module_network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private val builder = Retrofit.Builder()
        .baseUrl("http://c.m.163.com/nc/")
        .addConverterFactory(GsonConverterFactory.create())



    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}