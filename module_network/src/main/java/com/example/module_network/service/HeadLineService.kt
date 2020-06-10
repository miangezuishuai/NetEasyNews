package com.example.module_network.service

import com.example.module_network.model.HeadLine
import retrofit2.Call
import retrofit2.http.GET

interface HeadLineService {

    @GET("article/headline/T1348647853363/0-40.html")
    fun getHeadLine() :Call<HeadLine>
}