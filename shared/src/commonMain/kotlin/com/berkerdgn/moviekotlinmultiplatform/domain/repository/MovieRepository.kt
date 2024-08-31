package com.berkerdgn.moviekotlinmultiplatform.domain.repository

import com.berkerdgn.moviekotlinmultiplatform.domain.model.Movie

internal interface MovieRepository {

    suspend fun getMovies() : List<Movie>

    suspend fun getMovie(movieId : Int ): Movie

}