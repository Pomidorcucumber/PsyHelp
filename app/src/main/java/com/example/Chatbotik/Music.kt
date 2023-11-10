package com.example.Chatbotik

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityMainBinding
import com.example.chatbotik.databinding.ActivityMusicBinding

class Music : AppCompatActivity() {
    lateinit var binding: ActivityMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = binding.videoView

        val videoUrl = "android.resource://$packageName" + "/" + R.raw.video
        val videoUri = Uri.parse(videoUrl);
        videoView.setVideoURI(videoUri);

        val mediaController = MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
