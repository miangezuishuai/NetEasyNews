package com.example.neteasynews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neteasynews.comment.BaseFragment

abstract class RecyclerFragment :BaseFragment() {

    abstract fun layoutResource():Int //填入要填充的布局

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResource(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerSetting()
        getNewList()
    }

    abstract fun getNewList()   //新闻信息的获取

    abstract fun recyclerSetting()  //RecyclerView的设置

}