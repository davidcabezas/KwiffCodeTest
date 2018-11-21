package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.repository.MovieRepository
import io.reactivex.Single

/**
 * Created by David C. on 21/11/2018.
 */
class MovieListInteractorImpl(private val movieRepository: MovieRepository) : MovieListInteractor {

    override fun getMovieList(): Single<List<Movie>> = movieRepository.getAllNowPlayingMovies()

}