package com.example.Chatbotik.fragments.mainScreen.movie_podcasts

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    private var isPaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val videoResId = intent.getIntExtra("VIDEO_RES_ID", 0)
        binding.videoView.setVideoURI(Uri.parse("android.resource://$packageName/$videoResId"))
        binding.videoView.start()
        binding.imageView15.setOnClickListener {
            toggleVideoPlayback()
        }
        binding.imageView14.setOnClickListener {
            finish()
        }
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    private fun toggleVideoPlayback() {
        isPaused = if (isPaused) {
            binding.videoView.start()
            binding.imageView15.setImageResource(com.google.android.exoplayer2.ui.R.drawable.exo_controls_pause)

            false
        } else {
            binding.videoView.pause()
            binding.imageView15.setImageResource(com.google.android.exoplayer2.R.drawable.exo_icon_play)
            true
        }
    }

}
