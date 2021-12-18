package com.aswin.phonepe.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aswin.phonepe.api.ApiResult
import com.aswin.phonepe.models.movie.MovieData
import com.aswin.phonepe.repositories.movie.MovieRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepositoryInterface) :
    ViewModel() {

    private val showLoaderMLD = MutableLiveData(false)
    val showLoaderLD: LiveData<Boolean> = showLoaderMLD

    private val showErrorMLD = MutableLiveData<String?>()
    val showErrorLD: LiveData<String?> = showErrorMLD
    fun resetError() {
        showErrorMLD.value = null
    }

    private val movieListMLD = MutableLiveData<List<MovieData>?>()
    val movieListLD: LiveData<List<MovieData>?> = movieListMLD

    init {
        fetchMovieList()
    }

    private fun fetchMovieList() {
        viewModelScope.launch {
            showLoaderMLD.value = true
            when (val response = movieRepository.fetchMovieList()) {
                is ApiResult.Success -> {
                    movieListMLD.value = response.data?.results
                }
                is ApiResult.Error -> showErrorMLD.value = response.errorMessage
            }
            showLoaderMLD.value = false
        }
    }
}