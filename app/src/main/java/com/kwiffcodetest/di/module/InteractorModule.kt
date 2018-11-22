package com.kwiffcodetest.di.module

import com.kwiffcodetest.repository.MovieRepository
import com.kwiffcodetest.ui.moviedetail.MovieDetailInteractor
import com.kwiffcodetest.ui.moviedetail.MovieDetailInteractorImpl
import com.kwiffcodetest.ui.movielist.MovieListInteractor
import com.kwiffcodetest.ui.movielist.MovieListInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by David C. on 21/11/2018.
 */
@Module
class InteractorModule {

    @Provides
    @Singleton
    fun getMovieListInteractor(movieRepository: MovieRepository): MovieListInteractor =
            MovieListInteractorImpl(movieRepository)

    @Provides
    @Singleton
    fun getMovieDetailInteractor(movieRepository: MovieRepository): MovieDetailInteractor =
            MovieDetailInteractorImpl(movieRepository)

}