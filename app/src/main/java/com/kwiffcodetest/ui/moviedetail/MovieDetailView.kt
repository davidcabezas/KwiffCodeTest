package com.kwiffcodetest.ui.moviedetail

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BaseView

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieDetailView : BaseView {

    fun printMovieDetails(movie: Movie)

}