package com.example.module_network.service

import com.example.module_network.model.Car
import retrofit2.Call
import retrofit2.http.GET

interface CarService {
    @GET("auto/list/6YOR5bee/0-20.html")
    fun getCar() : Call<Car>
}