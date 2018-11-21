package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BaseView
import com.kwiffcodetest.util.SharedViewData

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieListView : BaseView {

    fun printMovieList(movieList: List<Movie>)

    fun showMovieDetailsView(movieId: Int, sharedViewData: SharedViewData)

}