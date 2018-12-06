package com.kwiffcodetest.repository

import com.kwiffcodetest.data.Collection
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.data.Results
import com.kwiffcodetest.retrofit.MovieApi
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieRepository
@Inject
constructor(val movieApi: MovieApi) : MovieApi {

    override fun getAllNowPlayingMovies(): Single<Results<List<Movie>>> = movieApi.getAllNowPlayingMovies()

    override fun getMovieDetails(movieId: Int): Single<Movie> = movieApi.getMovieDetails(movieId)

    override fun getCollectionOfMoviesById(collectionId: Int): Single<Collection> = movieApi.getCollectionOfMoviesById(collectionId)

}