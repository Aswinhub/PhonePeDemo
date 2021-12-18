package com.aswin.phonepe.models.movie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class MovieApiResponse(
    val page: Int,
    val results: List<MovieData>,
    val total_pages: Int,
    val total_results: Int
)

@Parcelize
data class MovieData(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable {
    fun getImageUrl(): String {
        return "https://image.tmdb.org/t/p/w500$backdrop_path"
    }
}
