package com.example.Chatbotik.fragments.mainScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatbotik.databinding.FragmentPodcastsBinding

class PodcastsFragment : Fragment() {
    private lateinit var binding: FragmentPodcastsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPodcastsBinding.inflate(inflater, container, false)
        return binding.root
    }
}