package com.aswin.phonepe.di

import com.aswin.phonepe.api.RetrofitBuilder
import com.aswin.phonepe.api.services.MovieApiService
import com.aswin.phonepe.repositories.movie.MovieRepository
import com.aswin.phonepe.repositories.movie.MovieRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit {
        return RetrofitBuilder.getRetrofit()
    }

    @Singleton
    @Provides
    fun movieApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }

    @Singleton
    @Provides
    fun movieRepository(movieApiService: MovieApiService): MovieRepositoryInterface {
        return MovieRepository(movieApiService)
    }
}