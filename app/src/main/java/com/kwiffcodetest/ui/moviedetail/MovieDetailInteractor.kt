package com.kwiffcodetest.ui.moviedetail

import com.kwiffcodetest.data.Collection
import com.kwiffcodetest.data.Movie
import io.reactivex.Single

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieDetailInteractor {

    fun getMovieDetails(movieId: Int): Single<Movie>

    fun getMovieCollection(collectionId: Int): Single<Collection>

}