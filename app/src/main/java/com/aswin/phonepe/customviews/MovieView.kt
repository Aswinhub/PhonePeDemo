package com.aswin.phonepe.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.aswin.phonepe.R
import com.aswin.phonepe.customviews.movieView.MovieViewInterface
import com.aswin.phonepe.databinding.ViewMovieBinding
import com.aswin.phonepe.models.movie.MovieData

class MovieView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    private val mBinding = ViewMovieBinding.inflate(LayoutInflater.from(context), this, true)
    private var isFavourite = false
    fun setData(movieData: MovieData, movieViewInterface: MovieViewInterface) {
        mBinding.movieData = movieData

        mBinding.favouriteIv.setOnClickListener {
            movieViewInterface.addToFavourite(movieData)
            isFavourite = !isFavourite
            setFavourite(isFavourite)
        }
    }

    private fun setFavourite(isSelected: Boolean) {
        val icon = if (isSelected) {
            R.drawable.ic_star_selected
        } else {
            R.drawable.ic_star_outline
        }
        mBinding.favouriteIv.setImageDrawable(ContextCompat.getDrawable(context, icon))
    }
}