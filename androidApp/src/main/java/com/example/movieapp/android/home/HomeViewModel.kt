package com.example.movieapp.android.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domein.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
     var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadMovies(forceReload = false)
    }

    fun loadMovies(forceReload: Boolean = false) {
        Log.d("bekbek", "loadMovies")
        if (uiState.loading) return

        if (forceReload) {
            currentPage = 1
        }

        if (currentPage == 1) {
            uiState = uiState.copy(refreshing = true)
        }

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            try {
                Log.d("bekbek", "loadMovies 1")
                val resultMovies = getMoviesUseCase(page = currentPage)

                val movies = if (currentPage == 1) resultMovies else uiState.movies + resultMovies

                currentPage += 1

                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = resultMovies.isNotEmpty(),
                    movies = movies
                )
                Log.d("bekbek", "loadMovies 2 $movies")
            } catch (e: Exception) {
                Log.d("bekbek", "loadMovies e: ${e.localizedMessage}")
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Could not load: ${e.localizedMessage}"
                )
            }
        }
    }
}