package com.kwiffcodetest.ui.moviedetail

import com.kwiffcodetest.ui.movie.MoviePresenter

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieDetailPresenter : MoviePresenter<MovieDetailView> {

    fun getMovieDetails(movieId: Int)

}