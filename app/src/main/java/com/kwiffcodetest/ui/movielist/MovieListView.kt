package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.movie.MovieView

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieListView : MovieView {

    fun printMovieList(movieList: List<Movie>)

}