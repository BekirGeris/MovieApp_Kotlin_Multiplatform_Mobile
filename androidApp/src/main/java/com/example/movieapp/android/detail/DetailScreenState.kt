package com.example.movieapp.android.detail

import com.example.movieapp.domein.model.Movie

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)
