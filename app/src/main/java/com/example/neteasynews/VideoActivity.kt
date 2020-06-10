package com.example.neteasynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.neteasynews.comment.BaseActivity
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        val video_url = intent.getStringExtra("video_url")
        video_view.setMediaController(MediaController(this))
        video_view.setVideoPath(video_url)
        video_view.requestFocus()
        video_view.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (video_view != null) {
            video_view.suspend()
        }
    }
}
