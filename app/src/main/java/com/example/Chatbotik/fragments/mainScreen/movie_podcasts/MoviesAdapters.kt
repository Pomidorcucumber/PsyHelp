package com.example.Chatbotik.fragments.mainScreen.movie_podcasts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbotik.R

class MoviesAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.movieTitle)
        val imageView: ImageView = itemView.findViewById(R.id.movieImage)
        init {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val movie = movies[position]
                    itemView.context.startActivity(
                        Intent(itemView.context, MovieActivity::class.java).apply {
                            putExtra(
                                "VIDEO_RES_ID", when (movie.videoUrl) {
                                    "dog" -> R.raw.dog
                                    "cat" -> R.raw.cat
                                    else -> 0
                                }
                            )
                        }
                    )
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleTextView.text = movie.title
        holder.imageView.setImageResource(movie.imageUrl)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
