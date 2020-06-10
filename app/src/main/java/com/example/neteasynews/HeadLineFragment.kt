package com.example.neteasynews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.example.module_network.ServiceCreator
import com.example.module_network.model.HeadLine
import com.example.module_network.service.HeadLineService
import com.example.neteasynews.adapter.NewsAdapter
import com.example.neteasynews.comment.BaseFragment
import com.example.neteasynews.comment.LogUtil
import kotlinx.android.synthetic.main.frag_head_line.*
import retrofit2.Call
import retrofit2.Callback


class HeadLineFragment :RecyclerFragment() {
    override fun layoutResource(): Int {
        return R.layout.frag_head_line
    }

    override fun getNewList() {
        val service = ServiceCreator.create(HeadLineService::class.java)
        service.getHeadLine().enqueue(object: Callback<HeadLine?> {
            override fun onFailure(call: Call<HeadLine?>, t: Throwable) {

            }

            override fun onResponse(call: Call<HeadLine?>, response: retrofit2.Response<HeadLine?>) {
                val list = response.body()!!.T1348647853363
                val adapter = activity?.let { NewsAdapter(it,list) }
                recy_index.adapter = adapter
            }
        })
    }

    override fun recyclerSetting() {
        val layoutManager: LinearLayoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        recy_index.layoutManager = layoutManager
    }
}