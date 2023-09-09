package com.example.movieapp.domein.repository

import com.example.movieapp.domein.model.Movie

interface MovieRepository {
    suspend fun getMovies(page: Int) : List<Movie>
    suspend fun getMovie(movieId: Int) : Movie
}