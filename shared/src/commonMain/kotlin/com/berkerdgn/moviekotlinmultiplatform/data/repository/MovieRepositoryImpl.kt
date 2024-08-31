package com.berkerdgn.moviekotlinmultiplatform.data.repository

import com.berkerdgn.moviekotlinmultiplatform.data.remote.RemoteDataSource
import com.berkerdgn.moviekotlinmultiplatform.data.util.toMovie
import com.berkerdgn.moviekotlinmultiplatform.domain.model.Movie
import com.berkerdgn.moviekotlinmultiplatform.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val dataSource: RemoteDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie> {
            return dataSource.getMovies().results.map {
                it.toMovie()
            }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return  dataSource.getMovie(movieId).toMovie()
    }
}