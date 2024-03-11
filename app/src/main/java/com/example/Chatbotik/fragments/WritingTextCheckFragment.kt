package com.example.Chatbotik.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chatbotik.databinding.FragmentWritingTextCheckBinding

class WritingTextCheckFragment : Fragment() {
    private lateinit var binding: FragmentWritingTextCheckBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWritingTextCheckBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.textView11.visibility = View.INVISIBLE
        return view
    }

//    fun checkAnswerAndDisplay() {
//        val answer = binding.editText.text.toString().trim()
//        val result = checkTextWithLanguageTool(answer)
//        binding.textView11.text = result
//        binding.textView11.visibility = View.VISIBLE
//    }
//    private fun checkTextWithLanguageTool(text: String): String {
//        val languageTool = JLanguageTool()
//        val matches = languageTool.check(text)
//        val stringBuilder = StringBuilder()
//        for (match in matches) {
//            stringBuilder.append(match.message).append("\n")
//        }
//        return stringBuilder.toString()
//    }
}