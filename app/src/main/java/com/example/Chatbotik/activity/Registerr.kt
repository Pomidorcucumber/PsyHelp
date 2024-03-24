package com.example.Chatbotik.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.chatbotik.R
import com.example.chatbotik.databinding.ActivityRegisterrBinding


class Registerr : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        binding.imageView2.setOnClickListener {
            finish()
        }

            binding.button8.setOnClickListener {
                if(binding.editTextText.text.isNotEmpty() && binding.editTextText2.text
                        .isNotEmpty()) {
                    val intent = Intent(this, Meeting::class.java)

                    val namePer1 = binding.editTextText.text
                    val surnamePer1 = binding.editTextText2.text
                    Log.d("MyLog", "$namePer1 $surnamePer1")
                    intent.putExtra("namePer1", "$namePer1")
                    intent.putExtra("surnamePer1", "$surnamePer1")
                    val sharedPreferences =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("reg", "yes")
                    editor.putString("name", "$namePer1")
                    editor.putString("surname", "$surnamePer1")
                    editor.apply()

                    startActivity(intent)
                    finish()
                }
            }

        binding.editTextText.addTextChangedListener(textWatcher)
        binding.editTextText2.addTextChangedListener(textWatcher);
    }
    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        @SuppressLint("ResourceAsColor")
        override fun afterTextChanged(editable: Editable) {
            val areBothFilled =
                binding.editTextText.text.isNotEmpty() && binding.editTextText2.text
                    .isNotEmpty()

            if (areBothFilled) {
                binding.button8.setBackgroundColor(R.color.blue)
                binding.button8.setTextColor(Color.WHITE)
            } else {
                binding.button8.setBackgroundColor(Color.GRAY)
                binding.button8.setTextColor(Color.BLACK)
            }
        }
    }
}