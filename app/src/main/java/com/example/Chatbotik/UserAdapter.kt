package com.example.Chatbotik

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbotik.databinding.UserListItemBinding
import com.google.firebase.auth.FirebaseAuth

class UserAdapter : ListAdapter<User, UserAdapter.ItemHolder>(ItemComparator()) {
    lateinit var auth: FirebaseAuth
    class ItemHolder(private val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root){
//        auth = Firebase.auth
//        val selectedChatId = auth.currentUser?.displayName
        fun bind(user: User) = with(binding){
            message.text = user.message
//            message.setTextColor(Color.BLACK)
//            message.setBackgroundColor(Color.YELLOW)
            userName.text = user.name
        }
        companion object{
            fun create(parent: ViewGroup): ItemHolder{
                return ItemHolder(UserListItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<User>(){
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
        holder.bind(getItem(position))
    }
}