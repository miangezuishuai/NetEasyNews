package com.example.neteasynews

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module_network.ServiceCreator
import com.example.module_network.model.Sport
import com.example.module_network.service.SportService

import com.example.neteasynews.adapter.NewsAdapter
import com.example.neteasynews.comment.LogUtil
import kotlinx.android.synthetic.main.frag_sport.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportFragment :RecyclerFragment() {
    override fun layoutResource(): Int {
        return R.layout.frag_sport
    }

    override fun getNewList() {
        val service = ServiceCreator.create(SportService::class.java)
        service.getSport().enqueue(object: Callback<Sport?> {
            override fun onFailure(call: Call<Sport?>, t: Throwable) {

            }

            override fun onResponse(call: Call<Sport?>, response: Response<Sport?>) {
                LogUtil.d("SportFragment",response.message())
                val list = response.body()!!.T1348649079062
                val adapter = activity?.let { NewsAdapter(it,list) }
                recy_car.adapter = adapter
            }
        })


    }

    override fun recyclerSetting() {
        val layoutManager: LinearLayoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        recy_car.layoutManager = layoutManager
    }
}