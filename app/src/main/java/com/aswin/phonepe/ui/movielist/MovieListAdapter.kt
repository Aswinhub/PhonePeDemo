package com.aswin.phonepe.ui.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aswin.phonepe.databinding.MovieListItemViewBinding
import com.aswin.phonepe.models.movie.MovieData

class MovieListAdapter(private val movieListAdapterInterface: MovieListAdapterInterface) :
    RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private val movieList = arrayListOf<MovieData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieListItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setData(data: List<MovieData>) {
        movieList.clear()
        movieList.addAll(data)
        notifyItemRangeChanged(0, data.size)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieViewHolder(private val binding: MovieListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.movieView.setData(movieList[position], movieListAdapterInterface)
        }
    }

}