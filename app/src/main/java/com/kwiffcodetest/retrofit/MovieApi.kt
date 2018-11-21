package com.kwiffcodetest.retrofit

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.data.Results
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by David C. on 21/11/2018.
 */
interface MovieApi {

    @GET("movie/now_playing")
    fun getAllNowPlayingMovies(): Single<Results<List<Movie>>>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int): Single<Movie>

    @GET("collection/{collection_id}")
    fun getCollectionOfMoviesById(@Path("collection_id") collectionId: Int): Single<Results<List<Movie>>>

}