package com.example.neteasynews.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.module_network.model.Response
import com.example.neteasynews.R
import com.example.neteasynews.WebViewActivity
import com.example.neteasynews.comment.LogUtil


class NewsAdapter(val context: Context,val newsList:List<Response>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)

        val holder = ViewHolder(view)
        holder.title.setOnClickListener {
            val position = holder.adapterPosition
            LogUtil.d("NewsAdapter",""+position)
            var news = newsList.get(position)
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("web_url",news.url)
            context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var news = newsList.get(position)
        holder.source.text = news.source
        holder.time.text = news.mtime
        holder.title.text = news.title
        Glide.with(context).load(news.imgsrc).into(holder.image)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title:TextView = view.findViewById(R.id.news_item_title)
        var source:TextView = view.findViewById(R.id.news_item_source)
        var time:TextView = view.findViewById(R.id.news_item_time)
        var image:ImageView = view.findViewById(R.id.news_item_image)
    }
}