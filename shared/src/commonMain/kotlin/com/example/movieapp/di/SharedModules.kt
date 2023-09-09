package com.example.movieapp.di

import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.data.remote.RemoteDataSource
import com.example.movieapp.domein.repository.MovieRepository
import com.example.movieapp.domein.repository.MovieRepositoryImpl
import com.example.movieapp.domein.usecase.GetMovieUseCase
import com.example.movieapp.domein.usecase.GetMoviesUseCase
import com.example.movieapp.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}

private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules