package com.berkerdgn.moviekotlinmultiplatform.android.home

import com.berkerdgn.moviekotlinmultiplatform.domain.model.Movie

data class HomeScreenState(
    val loading : Boolean = false,
    val refreshing : Boolean = false,
    val movies : List<Movie> = listOf(),
    var errorMessage : String? = null,
    var loadFinished : Boolean = false,
)
