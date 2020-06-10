package com.example.neteasynews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neteasynews.comment.BaseFragment
import com.example.neteasynews.comment.LogUtil

class TextFragment :BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d("TextFragment","onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.d("TextFragment","onDestory")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_text,container,false)
    }
}