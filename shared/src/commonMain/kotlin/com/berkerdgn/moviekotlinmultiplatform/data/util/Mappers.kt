package com.berkerdgn.moviekotlinmultiplatform.data.util

import com.berkerdgn.moviekotlinmultiplatform.data.remote.MovieRemote
import com.berkerdgn.moviekotlinmultiplatform.domain.model.Movie

internal  fun  MovieRemote.toMovie(): Movie{
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(postImage),
        releaseDate = releaseDate,
    )
}

private fun getImageUrl(posterImage: String)= "https://image.tmdb.org/t/p/w500/$posterImage"