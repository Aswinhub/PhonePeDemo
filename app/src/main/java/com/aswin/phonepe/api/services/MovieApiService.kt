package com.aswin.phonepe.api.services

import com.aswin.phonepe.api.RetrofitBuilder
import com.aswin.phonepe.models.movie.MovieApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movies/get-popular-movies")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = RetrofitBuilder.API_KEY
    ): Response<MovieApiResponse>
}