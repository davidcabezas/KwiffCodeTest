package com.kwiffcodetest.ui.moviedetail

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.repository.MovieRepository
import io.reactivex.Single

/**
 * Created by David C. on 21/11/2018.
 */
class MovieDetailInteractorImpl(private val movieRepository: MovieRepository) : MovieDetailInteractor {

    override fun getMovieDetails(movieId: Int): Single<Movie> = movieRepository.getMovieDetails(movieId)

}