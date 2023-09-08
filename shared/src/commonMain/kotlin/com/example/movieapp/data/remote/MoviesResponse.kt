package com.example.movieapp.data.remote

import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponse(
    val result: List<MovieRemote>
)