package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.ui.movie.MoviePresenter

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieListPresenter : MoviePresenter<MovieListView> {

    fun getAllMovies()

}