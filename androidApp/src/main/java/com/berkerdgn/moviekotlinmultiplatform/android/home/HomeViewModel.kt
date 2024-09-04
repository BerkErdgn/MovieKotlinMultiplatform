package com.berkerdgn.moviekotlinmultiplatform.android.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkerdgn.moviekotlinmultiplatform.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadMovies(forceReload = false)
    }

    fun loadMovies(forceReload: Boolean = false) {
        if (uiState.loading) {
            return
        }
        if (forceReload) {
            currentPage = 1
        }
        if (currentPage == 1) {
            uiState = uiState.copy(refreshing = true)
        }

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            try {
                val resultMovies = getMoviesUseCase()
                val movies = if (currentPage == 1) resultMovies else uiState.movies + resultMovies

                currentPage +=1

                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = resultMovies.isEmpty(),
                    movies = movies
                )


            }catch (e:Throwable){
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = e.localizedMessage
                )
            }


        }


    }


}