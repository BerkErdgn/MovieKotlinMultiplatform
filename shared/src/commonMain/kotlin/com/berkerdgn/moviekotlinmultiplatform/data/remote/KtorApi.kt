package com.berkerdgn.moviekotlinmultiplatform.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//https://github.com/atilsamancioglu/MovieAppKMM
//https://github.com/atilsamancioglu/KMMMovieSampleData
//https://github.com/atilsamancioglu/KMMMovieSampleData/blob/main/movie.json
//https://github.com/atilsamancioglu/KMMMovieSampleData/blob/main/popular.json

private const val BASE_URL =
    "https://github.com/atilsamancioglu/"
private const val API_KEY = ""

internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                //ignoreUnknownKeys saece keyleri yazpı hepsini yerine ihtiyacımız olanları alıca gerisini boşuna cekmeyeceğiz
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            //parameters("api_key", API_KEY)
        }
    }


}