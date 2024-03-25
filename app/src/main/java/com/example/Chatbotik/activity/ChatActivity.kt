package com.example.Chatbotik.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Chatbotik.userInfo.User
import com.example.Chatbotik.userInfo.UserAdapter
import com.example.chatbotik.databinding.ActivityChatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatActivity : AppCompatActivity() {
    lateinit var binding: ActivityChatBinding
    lateinit var auth: FirebaseAuth
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val nameSpec = intent.getStringExtra("chatId")
        val namePer = sharedPreferences.getString("name", "Ivan")
        val language = sharedPreferences.getString("language", "no idea")
        val surnamePer = sharedPreferences.getString("surname", "Ivanovich")
        Log.d("MyLog","$namePer $surnamePer")
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        setUpActionBar()
        val database = Firebase.database
        val selectedChatId = if (auth.currentUser?.displayName.isNullOrEmpty())"$namePer $surnamePer" else auth.currentUser?.displayName
        val myRef = database.getReference("messages/$language/$nameSpec")
        binding.bSend.setOnClickListener {
            val sharedPreferences =
                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val value = sharedPreferences.getInt("num_message", 0) + 1
            val editor = sharedPreferences.edit()
            editor.putInt("num_message", value)
            editor.apply()
            myRef.child(myRef.push().key ?: "blabla").setValue(User(selectedChatId, binding.edMessage.text.toString()))
            binding.edMessage.setText("")
        }
        binding.imageView.setOnClickListener {
            val i = Intent(this, ChooseTaskActivity::class.java)
            startActivity(i)
            finish()
        }
        onChangeListener(myRef)
        initRcView()

    }

    private fun initRcView() = with(binding){
        adapter = UserAdapter()
        rcView.layoutManager = LinearLayoutManager(this@ChatActivity)
        rcView.adapter = adapter

    }


    private fun onChangeListener(dRef: DatabaseReference){
        auth = Firebase.auth
        dRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User>()
                for(s in snapshot.children){
                    val user = s.getValue(User::class.java)
                    if(user != null)list.add(user)
                }
                adapter.submitList(list)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun setUpActionBar(){
        val ab = supportActionBar
        Thread{
            runOnUiThread {
                val remakename = intent.getStringExtra("chatId")
                ab?.title = "$remakename"
            }
        }.start()

    }
}