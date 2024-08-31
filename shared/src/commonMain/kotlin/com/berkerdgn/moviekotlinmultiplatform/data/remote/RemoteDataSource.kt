package com.berkerdgn.moviekotlinmultiplatform.data.remote

import com.berkerdgn.moviekotlinmultiplatform.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher,
) {

    suspend fun getMovies() = withContext(dispatcher.io){
        apiService.getMovies()
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io){
        apiService.getMovie(movieId = movieId)
    }

}