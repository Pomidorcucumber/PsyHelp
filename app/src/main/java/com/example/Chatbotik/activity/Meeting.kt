package com.example.Chatbotik.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.chatbotik.R
import com.example.Chatbotik.notification.NotificationPermissionDialog
import com.example.chatbotik.databinding.ActivityMeetingBinding
import java.util.Timer
import kotlin.concurrent.timerTask


class Meeting : AppCompatActivity() {
    private lateinit var binding: ActivityMeetingBinding
    private var autoTypeText = "Hi there! I'm Swift!"
    private var delay: Long = 50
    private var timer = Timer()


    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMeetingBinding.inflate(layoutInflater)
        binding.progressBar2.visibility = View.INVISIBLE
        binding.radiotapok.visibility = View.GONE
        binding.checktapok.visibility = View.GONE
        setContentView(binding.root)
        supportActionBar!!.hide()
        startAutoTypeText()
        var howManyClick = 0

        binding.imageView5.setOnClickListener {
            val i = Intent(this, Registerr::class.java)
            startActivity(i)
        }
        binding.button9.setOnClickListener {
            howManyClick++
            when (howManyClick) {
                1 -> {
                    timer = Timer()
                    delay = 25
                    autoTypeText = "Just 7 quick questions \n before we start your first\n lesson!"
                    val animation = TranslateAnimation(0f, 0f, 175f, 0f)
                    animation.duration = 100
                    binding.textView7.translationY = -175f
                    binding.textView7.startAnimation(animation)
                    startAutoTypeText()
                    binding.imageView4.setImageResource(R.drawable.enotbighey)
                }

                2 -> {
                    binding.textView7.visibility = View.INVISIBLE
                    binding.progressBar2.progress = 20
                    binding.progressBar2.visibility = View.VISIBLE
                    val animation = TranslateAnimation(0f, -350f, 0f, -850f)
                    animation.duration = 1500
                    animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation?) {}

                        override fun onAnimationEnd(animation: Animation?) {
                            binding.imageView4.translationY = -850f
                            binding.imageView4.translationX = -350f
                            binding.textView7.translationY = -600f
                            binding.textView7.translationX = 150f
                            binding.textView7.visibility = View.VISIBLE
                            timer = Timer()
                            delay = 25
                            autoTypeText = "What would you like to \n learn?"
                            startAutoTypeText()
                            val usaDrawable1: Drawable? =
                                ContextCompat.getDrawable(this@Meeting, R.drawable.usa)
                            binding.option1.setCompoundDrawablesWithIntrinsicBounds(
                                usaDrawable1,
                                null,
                                null,
                                null
                            )
                            val usaDrawable2: Drawable? =
                                ContextCompat.getDrawable(this@Meeting, R.drawable.russia)
                            binding.option2.setCompoundDrawablesWithIntrinsicBounds(
                                usaDrawable2,
                                null,
                                null,
                                null
                            )
                            val usaDrawable3: Drawable? =
                                ContextCompat.getDrawable(this@Meeting, R.drawable.germany)
                            binding.option3.setCompoundDrawablesWithIntrinsicBounds(
                                usaDrawable3,
                                null,
                                null,
                                null
                            )
                            binding.radiotapok.visibility = View.VISIBLE
                            binding.option.visibility = View.GONE
                        }

                        override fun onAnimationRepeat(animation: Animation?) {}
                    })
                    binding.imageView4.startAnimation(animation)
                }

                3 -> {
                    if (binding.option1.isChecked || binding.option2.isChecked || binding.option3.isChecked) {
                        binding.radiotapok.visibility = View.INVISIBLE
                        if (binding.option1.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("language", binding.option1.text.toString())
                            editor.apply()
                        }

                        if (binding.option2.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("language", binding.option2.text.toString())
                            editor.apply()
                        }
                        val sharedPreferences =
                            getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                        val retrievedText =
                            sharedPreferences.getString("language", "Нет сохраненного текста")
                        timer = Timer()
                        delay = 25
                        autoTypeText = "How much $retrievedText do\n you know?"
                        startAutoTypeText()
                        binding.progressBar2.progress = 40

                        binding.option3.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option2.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option1.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option.setButtonDrawable(android.R.drawable.btn_radio)
                        binding.option3.isClickable = true
                        val usaDrawable1: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.firstlevel)
                        binding.option1.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable1,
                            null,
                            null,
                            null
                        )
                        val usaDrawable2: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.secondlevel)
                        binding.option2.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable2,
                            null,
                            null,
                            null
                        )
                        val usaDrawable3: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.thirdlevel)
                        binding.option3.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable3,
                            null,
                            null,
                            null
                        )
                        val usaDrawable: Drawable? =
                            ContextCompat.getDrawable(this@Meeting, R.drawable.forthlevel)
                        binding.option.setCompoundDrawablesWithIntrinsicBounds(
                            usaDrawable,
                            null,
                            null,
                            null
                        )
                        binding.option.visibility = View.VISIBLE
                        binding.radiotapok.visibility = View.VISIBLE
                        binding.option.text = "I am intermediate or higher"
                        binding.option1.text = "I'm new to $retrievedText"
                        binding.option2.text = "I know some words and phrases"
                        binding.option3.text = "I can have simple conversations"
                    } else {
                        howManyClick--
                        Toast.makeText(this, "Please select a language", Toast.LENGTH_SHORT).show()
                    }
                }

                4 -> {
                    if (binding.option1.isChecked || binding.option2.isChecked || binding.option3.isChecked || binding.option.isChecked) {
                        binding.radiotapok.visibility = View.INVISIBLE
                        if (binding.option1.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level1")
                            editor.apply()
                        }

                        if (binding.option2.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level2")
                            editor.apply()
                        }
                        if (binding.option3.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level3")
                            editor.apply()
                        }

                        if (binding.option.isChecked) {
                            val sharedPreferences =
                                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("level", "level4")
                            editor.apply()
                        }
                        val sharedPreferences =
                            getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                        val retrievedText =
                            sharedPreferences.getString("level", "Нет сохраненного текста")

                        timer = Timer()
                        delay = 25
                        autoTypeText = when (retrievedText) {
                            "level1" -> "Okay, let's start\n all over again!"
                            "level2" -> "That's good, let's\n go conquer new \nheights!"
                            "level3" -> "This is great,\n let's make it perfect!"
                            "level4" -> "Okay, great!"
                            else -> {
                                ""
                            }
                        }
                        startAutoTypeText()
                    } else {
                        howManyClick--
                        Toast.makeText(this, "Please select a level", Toast.LENGTH_SHORT).show()
                    }
                }

                5 -> {
                    binding.checktapok.visibility = View.VISIBLE
                    val sharedPreferences =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                    val retrievedText =
                        sharedPreferences.getString("language", "Нет сохраненного текста")
                    timer = Timer()
                    delay = 25
                    autoTypeText = "Why do you learning \n$retrievedText?"
                    startAutoTypeText()
                    binding.progressBar2.progress = 60
                    binding.check5.setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            binding.check.isChecked = false
                            binding.check1.isChecked = false
                            binding.check2.isChecked = false
                            binding.check3.isChecked = false
                            binding.check4.isChecked = false
                            binding.check5.setTextColor(
                                ContextCompat.getColor(
                                    this@Meeting,
                                    R.color.blue
                                )
                            )
                        } else {
                            binding.check5.setTextColor(
                                ContextCompat.getColor(
                                    this@Meeting,
                                    R.color.white
                                )
                            )
                        }
                    }

                    val checkBoxIds = listOf(
                        binding.check,
                        binding.check1,
                        binding.check2,
                        binding.check3,
                        binding.check4
                    )

                    for (checkBoxId in checkBoxIds) {

                        checkBoxId.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                binding.check5.isChecked = false
                            }
                        }
                    }
                }

                6 -> {
                    binding.progressBar2.progress = 80
                    binding.checktapok.visibility = View.GONE
                    val reasons = mutableListOf<String>()
                    val checkBoxes = listOf(
                        binding.check,
                        binding.check1,
                        binding.check2,
                        binding.check3,
                        binding.check4,
                        binding.check5
                    )

                    for (checkBox in checkBoxes) {
                        val reasonText = checkBox.text.toString()
                        if (checkBox.isChecked) {
                            reasons.add(reasonText)
                        }
                    }

                    if (reasons.size == 1) {
                        when (reasons[0]) {
                            getString(R.string.boost_my_career) -> binding.textView7.text =
                                "Let's open new horizons! "

                            getString(R.string.connect_with_people) -> binding.textView7.text =
                                "Let's get you ready\n to communicate!"

                            getString(R.string.just_for_fun) -> binding.textView7.text =
                                "Hooray! Fun is my forte!"

                            getString(R.string.other) -> binding.textView7.text =
                                "Any reason is a good\nreason to learn!"

                            getString(R.string.prepare_for_travel) -> binding.textView7.text =
                                "This is the best way\n to prepare for future travels!"

                            getString(R.string.support_my_education) -> binding.textView7.text =
                                "Ley's ace those tests"
                        }
                    } else {
                        binding.textView7.text = "Those all great\n reasons to learn!"
                    }
                    binding.imageView5.setOnClickListener {
                        howManyClick -= 2
                        binding.button9.performClick()
                    }
                }

                7 -> {
                    howManyClick--
                    binding.imageView6.visibility = View.VISIBLE
                    timer = Timer()
                    delay = 25
                    autoTypeText = "I will remind you to\n practise so it becomes\n a habit!"
                    startAutoTypeText()
                    val notificationPermissionDialog = NotificationPermissionDialog(this)
                    binding.imageView6.setOnClickListener {
                        notificationPermissionDialog.show()
                        howManyClick++
                    }

                }

                8 -> {
                    binding.progressBar2.progress = 100
                    binding.imageView6.visibility = View.GONE
                    timer = Timer()
                    delay = 25
                    autoTypeText = "Everything is ready,\n let's start the first lesson!"
                    startAutoTypeText()
                }

                9 -> {
                    val sharedPreferences =
                        getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("meet", "yes")
                    editor.apply()
                    val i = Intent(this, TaskActivity::class.java)
                    i.putExtra("task", R.array.first_meeting_task)
                    startActivity(i)
                }

            }

        }
    }

    private fun startAutoTypeText() {
        var index = 0
        timer.scheduleAtFixedRate(timerTask {
            runOnUiThread {
                if (index < autoTypeText.length) {
                    val currentText = autoTypeText.substring(0, index + 1)
                    binding.textView7.text = currentText
                    index++
                } else {
                    timer.cancel()
                }
            }
        }, delay, delay)
    }
}

