package com.example.module_network.service

import com.example.module_network.model.Sport
import retrofit2.Call
import retrofit2.http.GET

interface SportService {
    @GET("article/list/T1348649079062/0-20.html")
    fun getSport() : Call<Sport>
}