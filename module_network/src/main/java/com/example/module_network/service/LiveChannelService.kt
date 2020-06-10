package com.example.module_network.service

import com.example.module_network.model.livechannel.LiveChannel
import retrofit2.Call
import retrofit2.http.GET

interface LiveChannelService {
    @GET("livechannel/previewlist.json")
    fun getLiveChannel() : Call<LiveChannel>
}