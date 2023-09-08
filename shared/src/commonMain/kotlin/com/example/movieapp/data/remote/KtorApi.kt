package com.example.movieapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// 'https://api.themoviedb.org/3/movie/11?api_key=1362f61015da77d2bcfb1bf9a6bd2d02'
// https://api.themoviedb.org/3/movie//popular?page=1&api_key=1362f61015da77d2bcfb1bf9a6bd2d02

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "1362f61015da77d2bcfb1bf9a6bd2d02"

internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path("3", path)
            parameter("api_key", API_KEY)
        }
    }


}