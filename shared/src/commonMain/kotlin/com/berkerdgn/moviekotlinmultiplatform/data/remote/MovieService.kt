package com.berkerdgn.moviekotlinmultiplatform.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get

internal class MovieService : KtorApi(){

    suspend fun getMovies(): MoviesResponse = client.get {
        pathUrl("KMMMovieSampleData/blob/main/popular.json")
    }.body()

    suspend fun  getMovie(movieId : Int) : MovieRemote = client.get{
        pathUrl("KMMMovieSampleData/blob/main/movie.json")
    }.body()

}