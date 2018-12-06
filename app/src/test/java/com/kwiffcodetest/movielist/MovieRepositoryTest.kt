package com.kwiffcodetest.movielist

import com.kwiffcodetest.UnitTest
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.repository.MovieRepository
import com.kwiffcodetest.retrofit.MovieApi
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Call
import retrofit2.Response

/**
 * Created by David C. on 22/11/2018.
 */
class MovieRepositoryTest : UnitTest() { // Test not finished (run out of time)

    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieApi: MovieApi
    @Mock
    private lateinit var moviesCall: Call<List<Movie>>
    @Mock
    private lateinit var moviesResponse: Response<List<Movie>>

    private val mockMovie = Movie(0, "", 0.0, "", "", "", null)

    @Before
    fun setUp() {
        movieRepository = MovieRepository(movieApi)
    }

    @Test
    fun shouldReturnEmptyListByDefault() {

        given ( moviesResponse.body() ).willReturn(emptyList())
        given ( moviesResponse.isSuccessful ).willReturn(true)
        given ( moviesCall.execute() ).willReturn ( moviesResponse )
        //given ( movieApi.getAllNowPlayingMovies() ).willReturn ( moviesCall )

        val movies = movieRepository.getAllNowPlayingMovies()

        movies shouldEqual emptyList<Movie>()
        Mockito.verify(movieRepository).getAllNowPlayingMovies()

    }

    @Test
    fun shouldReturnMovieList() {

        given ( moviesResponse.body() ).willReturn(listOf(mockMovie))
        given ( moviesResponse.isSuccessful ).willReturn(true)
        given ( moviesCall.execute() ).willReturn ( moviesResponse )

        val movies = movieRepository.getAllNowPlayingMovies()

        movies shouldEqual listOf(mockMovie)
        Mockito.verify(movieRepository.getAllNowPlayingMovies())

    }

}