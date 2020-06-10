package com.example.neteasynews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.module_network.model.livechannel.BaseLiveChannel
import com.example.neteasynews.R
import com.example.neteasynews.comment.LogUtil

class LiveChannelAdapter(val context: Context, val liveList:List<BaseLiveChannel>) : RecyclerView.Adapter<LiveChannelAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)

        val holder = ViewHolder(view)
        holder.title.setOnClickListener {
            val position = holder.adapterPosition
            LogUtil.d("NewsAdapter",""+position)

        }
        return holder
    }

    override fun getItemCount(): Int {
        return liveList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var live = liveList.get(position)
        holder.source.text = live.source
        holder.time.text = live.startTime
        holder.title.text = live.roomName
        Glide.with(context).load(live.image).into(holder.image)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.news_item_title)
        var source: TextView = view.findViewById(R.id.news_item_source)
        var time: TextView = view.findViewById(R.id.news_item_time)
        var image: ImageView = view.findViewById(R.id.news_item_image)
    }


}