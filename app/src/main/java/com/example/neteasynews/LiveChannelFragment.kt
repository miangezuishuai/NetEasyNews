package com.example.neteasynews

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module_network.ServiceCreator2
import com.example.module_network.model.livechannel.LiveChannel
import com.example.module_network.service.LiveChannelService
import com.example.neteasynews.adapter.LiveChannelAdapter
import com.example.neteasynews.adapter.NowLiveChannelAdapter
import com.example.neteasynews.comment.LogUtil
import kotlinx.android.synthetic.main.frag_live_channel.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LiveChannelFragment:RecyclerFragment() {
    override fun layoutResource(): Int {
        return R.layout.frag_live_channel
    }

    override fun getNewList() {
        handleLive()
    }

    override fun recyclerSetting() {
        val layoutManager: LinearLayoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        recy_live_top.layoutManager = layoutManager

        val layoutManager2: LinearLayoutManager = LinearLayoutManager(activity)
        layoutManager2.orientation = RecyclerView.VERTICAL
        recy_live_now.layoutManager = layoutManager2

        val layoutManager3: LinearLayoutManager = LinearLayoutManager(activity)
        layoutManager3.orientation = RecyclerView.VERTICAL
        recy_live_future.layoutManager = layoutManager3
    }


    fun handleLive() {
        val service = ServiceCreator2.create(LiveChannelService::class.java)
        service.getLiveChannel().enqueue(object: Callback<LiveChannel?> {
            override fun onFailure(call: Call<LiveChannel?>, t: Throwable) {
                LogUtil.d("LiveChannelFragment","网络连接失败")
            }

            override fun onResponse(call: Call<LiveChannel?>, response: Response<LiveChannel?>) {
                val body = response.body()
                val list_top = body!!.top
                val adapter = activity?.let { LiveChannelAdapter(it,list_top) }
                recy_live_top.adapter = adapter

                val list_now = body!!.live_review
                val adapter_now = activity?.let { NowLiveChannelAdapter(it,list_now) }
                recy_live_now.adapter = adapter_now

                val list_future = body!!.future
                val adapter_future = activity?.let { LiveChannelAdapter(it,list_future) }
                recy_live_future.adapter = adapter_future
            }
        })
    }


}