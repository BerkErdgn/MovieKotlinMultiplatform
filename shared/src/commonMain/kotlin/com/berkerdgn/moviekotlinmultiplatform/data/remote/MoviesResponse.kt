package com.berkerdgn.moviekotlinmultiplatform.data.remote

import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponse(
    val results : List<MovieRemote>
)
