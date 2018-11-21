package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BasePresenter

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieListPresenter : BasePresenter<MovieListView> {

    fun getAllMovies()

    fun manageItemClick(movie: Movie)

}