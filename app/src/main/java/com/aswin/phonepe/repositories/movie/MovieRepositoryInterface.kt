package com.aswin.phonepe.repositories.movie

import com.aswin.phonepe.api.ApiResult
import com.aswin.phonepe.models.movie.MovieApiResponse

interface MovieRepositoryInterface {
    suspend fun fetchMovieList(): ApiResult<MovieApiResponse>
}