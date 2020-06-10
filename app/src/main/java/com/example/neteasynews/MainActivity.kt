package com.example.neteasynews


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.example.neteasynews.comment.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    val title = listOf<String>("头条","运动","直播")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

        main_viewpage2.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return title.size
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HeadLineFragment()
                    1 -> SportFragment()
                    2 -> LiveChannelFragment()
                    else -> TextFragment()
                }
            }
        }
        //tabLayout和Viewpage'联动
        TabLayoutMediator(main_tabLayout, main_viewpage2,{ tab, position ->  tab.text = title[position]}).attach()
    }

}
