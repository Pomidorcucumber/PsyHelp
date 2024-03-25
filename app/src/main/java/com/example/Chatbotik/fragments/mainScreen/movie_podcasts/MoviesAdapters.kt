package com.example.Chatbotik.fragments.mainScreen.movie_podcasts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatbotik.R

class MoviesAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.movieTitle)
        val imageView: ImageView = itemView.findViewById(R.id.movieImage)

        init {
            val sharedPreferences =
                context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
            val language = sharedPreferences.getString("language", "Нет сохраненного текста")
            itemView.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val movie = movies[position]
                    itemView.context.startActivity(
                        Intent(itemView.context, MovieActivity::class.java).apply {
                            putExtra(
                                "VIDEO_RES_ID", when (movie.videoUrl) {
                                    "film1" ->  if (language == context.getString(R.string.kazak_language)) R.raw.filmkz1 else if (language == context.getString(R.string.english))  R.raw.filmen1 else R.raw.filmru1
                                    "film2" ->  if (language == context.getString(R.string.kazak_language)) R.raw.filmkz2 else if (language == context.getString(R.string.english))  R.raw.filmen2 else R.raw.filmru2
                                    "film3"->  if (language == context.getString(R.string.kazak_language)) R.raw.filmkz2 else if (language == context.getString(R.string.english))  R.raw.multfilm_en else R.raw.filmru3
                                    "podcast1" ->  if (language == context.getString(R.string.kazak_language)) R.raw.podcastkz1 else if (language == context.getString(R.string.english)) R.raw.podkast_en1 else R.raw.podcastru1
                                    "podcast2" ->  if (language == context.getString(R.string.kazak_language)) R.raw.podcastkz2 else if (language == context.getString(R.string.english))  R.raw.podkasten2 else R.raw.podcastru2
                                    "podcast3"->  if (language == context.getString(R.string.kazak_language)) R.raw.podcastkz2 else if (language == context.getString(R.string.english)) R.raw.podcasten3 else R.raw.podcastru3
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
