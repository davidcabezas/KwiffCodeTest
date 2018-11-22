package com.kwiffcodetest.ui.moviedetail

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.movie.MovieView

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieDetailView : MovieView {

    fun showCollectionProgress(show: Boolean)

    fun printMovieDetails(movie: Movie)

    fun showCollectionLayout(show: Boolean)

    fun printCollection(movieList: List<Movie>)

}