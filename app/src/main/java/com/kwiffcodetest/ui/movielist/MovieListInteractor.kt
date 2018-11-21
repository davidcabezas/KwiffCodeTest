package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.data.Results
import io.reactivex.Single

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieListInteractor {

    fun getMovieList(): Single<Results<List<Movie>>>

}