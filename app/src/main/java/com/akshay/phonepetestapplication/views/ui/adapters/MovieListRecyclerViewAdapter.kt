package com.akshay.phonepetestapplication.views.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.akshay.phonepetestapplication.R
import com.akshay.phonepetestapplication.entities.MovieResult
import com.akshay.phonepetestapplication.network.Constants
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class MovieListRecyclerViewAdapter @Inject constructor(
    @ActivityContext val context: Context,
    private val movies: List<MovieResult>,
) : RecyclerView.Adapter<MovieListRecyclerViewAdapter.MoviesViewHolder>() {


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.titleView.text = movie.title
        holder.ratingsView.text = "Rating : ${movie.voteAverage}"

        holder.movieImage.load(
            Constants.BASE_IMAGE_URL + movie.posterPath
        )
    }


    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    class MoviesViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val titleView: AppCompatTextView = itemView.findViewById(R.id.title)
        val ratingsView: AppCompatTextView = itemView.findViewById(R.id.ratings)
        val playlist: AppCompatTextView = itemView.findViewById(R.id.playlist)
        val addToPlayList: AppCompatImageView = itemView.findViewById(R.id.addToPlaylist)
        val movieImage: AppCompatImageView = itemView.findViewById(R.id.movieImage)
    }

}