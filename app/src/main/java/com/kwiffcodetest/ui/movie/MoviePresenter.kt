package com.kwiffcodetest.ui.movie

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BasePresenter

/**
 * Created by David C. on 22/11/2018.
 */
interface MoviePresenter<T> : BasePresenter<T> {

    fun manageItemClick(movie: Movie)

}