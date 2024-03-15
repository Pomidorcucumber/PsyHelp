package com.example.Chatbotik.fragments.mainScreen.movie_podcasts

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPodcastsBinding.inflate(inflater, container, false)
        recyclerView = binding.recView1
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val movies = listOf(
            Movie("Фильм 1", R.drawable.place_holder, "dog"),
            Movie("Фильм 2", R.drawable.place_holder, "cat"),
            Movie("Фильм 3", R.drawable.place_holder, "dog"),
            Movie("Фильм 4", R.drawable.place_holder, "cat"),
            Movie("Фильм 5", R.drawable.place_holder, "dog")
        )

        adapter = MoviesAdapter(movies)
        recyclerView.adapter = adapter

        recyclerView = binding.recView2
        layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val podcasts = listOf(
            Movie("Podcast 1", R.drawable.place_holder, "dog"),
            Movie("Podcast 2", R.drawable.place_holder, "dog"),
            Movie("Podcast 3", R.drawable.place_holder, "dog"),
            Movie("Podcast 4", R.drawable.place_holder, "dog"),
            Movie("Podcast 5", R.drawable.place_holder, "dog")
        )

        adapter = MoviesAdapter(podcasts)
        recyclerView.adapter = adapter

        return binding.root
    }
}