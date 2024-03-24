package com.example.Chatbotik.fragments.mainScreen.movie_podcasts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Chatbotik.fragments.mainScreen.movie_podcasts.Movie
import com.example.Chatbotik.fragments.mainScreen.movie_podcasts.MoviesAdapter
import com.example.chatbotik.R
import com.example.chatbotik.databinding.FragmentPodcastsBinding

class PodcastsFragment : Fragment() {
    private lateinit var binding: FragmentPodcastsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPodcastsBinding.inflate(inflater, container, false)
        binding.imageView7.setImageResource(R.drawable.gladiator_gor)
        binding.imageView7.setOnClickListener {
            startActivity(Intent(requireContext(), MovieActivity::class.java).apply {
                putExtra(
                    "VIDEO_RES_ID",
                    R.raw.filmru1
                )
            })
        }
        recyclerView = binding.recView1
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val movies = listOf(
            Movie("Gladiators", R.drawable.gladiator_ver, "film1"),
            Movie("Bermold", R.drawable.bermold, "film2"),
            Movie("Gentelmens", R.drawable.gentelments, "film3")
        )

        adapter = MoviesAdapter(requireContext(), movies)
        recyclerView.adapter = adapter

        recyclerView = binding.recView2
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val podcasts = listOf(
            Movie("Elon Mask", R.drawable.elon_mask, "podcast1"),
            Movie("Story about family", R.drawable.family_podcast, "podcast2"),
            Movie("American about diet", R.drawable.american_about_diet, "podcast3")
        )

        adapter = MoviesAdapter(requireContext(), podcasts)
        recyclerView.adapter = adapter

        return binding.root
    }
}