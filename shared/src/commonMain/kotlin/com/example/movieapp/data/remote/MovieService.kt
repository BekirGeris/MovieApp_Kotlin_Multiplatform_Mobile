package com.example.movieapp.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi() {

    suspend fun getMovies(page: Int = 1) : MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(movieId: Int) : MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}