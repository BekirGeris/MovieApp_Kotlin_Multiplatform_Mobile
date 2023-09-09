package com.example.movieapp.domein.repository

import com.example.movieapp.data.remote.RemoteDataSource
import com.example.movieapp.data.util.toMovie
import com.example.movieapp.domein.model.Movie

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}