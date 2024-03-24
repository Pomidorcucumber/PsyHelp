package com.example.Chatbotik.userInfo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ChatItemBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserAdapter : ListAdapter<User, UserAdapter.ItemHolder>(ItemComparator()) {
    lateinit var auth: FirebaseAuth

    class ItemHolder(private val binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, isMyMessage: Boolean) = with(binding) {
            message.text = user.message
            userName.text = user.name
            photoUser.setImageResource(com.google.firebase.database.collection.R.drawable.common_google_signin_btn_icon_dark)
        }


        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    ChatItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        auth = Firebase.auth
        val currentUser = getItem(position)
        val isMyMessage = currentUser.name == auth.currentUser?.displayName
        holder.bind(currentUser, isMyMessage)
    }
}