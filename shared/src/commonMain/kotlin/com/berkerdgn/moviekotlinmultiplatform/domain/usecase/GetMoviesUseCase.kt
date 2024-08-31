package com.berkerdgn.moviekotlinmultiplatform.domain.usecase

import com.berkerdgn.moviekotlinmultiplatform.domain.model.Movie
import com.berkerdgn.moviekotlinmultiplatform.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMoviesUseCase :KoinComponent {
    private val repository : MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator  fun invoke(): List<Movie>{
        return  repository.getMovies()
    }


}