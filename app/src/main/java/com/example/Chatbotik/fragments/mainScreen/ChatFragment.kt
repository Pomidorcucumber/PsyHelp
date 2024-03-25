package com.example.Chatbotik.fragments.mainScreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.Chatbotik.activity.ChatActivity
import com.example.chatbotik.databinding.ActivityPsyChoosesBinding
import com.example.chatbotik.databinding.FragmentChatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        goNewView(binding)
        binding.textView23.setOnClickListener {
            openDiscordChannel(requireView())
        }
        return binding.root
    }

    private fun goNewView(binding: FragmentChatBinding) {
        binding.chatId1.setOnClickListener {
            intentSend(binding.TextViewId1.text.toString())
        }
        binding.chatId2.setOnClickListener {
            intentSend(binding.TextViewId2.text.toString())
        }
        binding.chatId3.setOnClickListener {
            intentSend(binding.TextViewId3.text.toString())
        }
        binding.chatId4.setOnClickListener {
            intentSend(binding.TextViewId4.text.toString())
        }
    }

    private fun intentSend(name: String) {
        val intent = Intent(requireContext(), ChatActivity::class.java)
        intent.putExtra("chatId", name)
        startActivity(intent)
    }
    fun openDiscordChannel(view: View) {
        val url = "https://discord.gg/tMMZSvxdRk"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}