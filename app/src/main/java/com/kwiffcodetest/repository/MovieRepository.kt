package com.kwiffcodetest.repository

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.retrofit.MovieApi
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieRepository
@Inject
constructor(retrofit: Retrofit) : MovieApi {

    private val TAG = javaClass.simpleName

    private val movieApi: MovieApi by lazy { retrofit.create(MovieApi::class.java) }

    override fun getAllNowPlayingMovies(): Single<List<Movie>> = movieApi.getAllNowPlayingMovies()

    override fun getMovieDetails(movieId: Int): Single<Movie> = movieApi.getMovieDetails(movieId)

    override fun getCollectionOfMoviesById(collectionId: Int): Single<List<Movie>> = movieApi.getCollectionOfMoviesById(collectionId)

}