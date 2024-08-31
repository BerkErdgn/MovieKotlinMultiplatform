package com.berkerdgn.moviekotlinmultiplatform.di

import com.berkerdgn.moviekotlinmultiplatform.data.remote.MovieService
import com.berkerdgn.moviekotlinmultiplatform.data.remote.RemoteDataSource
import com.berkerdgn.moviekotlinmultiplatform.data.repository.MovieRepositoryImpl
import com.berkerdgn.moviekotlinmultiplatform.domain.repository.MovieRepository
import com.berkerdgn.moviekotlinmultiplatform.domain.usecase.GetMovieUseCase
import com.berkerdgn.moviekotlinmultiplatform.domain.usecase.GetMoviesUseCase
import com.berkerdgn.moviekotlinmultiplatform.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory {
        RemoteDataSource(get(),get())
    }
    factory {
        MovieService()
    }
}

private val utilModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    factory {
        GetMoviesUseCase()
    }
    factory {
        GetMovieUseCase()
    }
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}
private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules