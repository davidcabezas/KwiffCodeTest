package com.kwiffcodetest.movielist

import com.kwiffcodetest.UnitTest
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.data.Results
import com.kwiffcodetest.repository.MovieRepository
import com.kwiffcodetest.ui.movielist.MovieListInteractor
import com.kwiffcodetest.ui.movielist.MovieListInteractorImpl
import io.reactivex.Single
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito

/**
 * Created by David C. on 22/11/2018.
 */
class MovieListInteractorTest : UnitTest() {

    private lateinit var movieListInteractor: MovieListInteractor

    @Mock private lateinit var movieRepository: MovieRepository

    private val mockMovie = Movie(0, "", 0.0, "", "", "", null)

    @Before fun setUp() {
        movieListInteractor = MovieListInteractorImpl(movieRepository)
        given (movieRepository.getAllNowPlayingMovies()).willReturn(Single.just(Results<List<Movie>>(listOf(mockMovie))))
    }

    @Test
    fun shouldGetDataFromRepository() {

        runBlocking {movieListInteractor.getMovieList()}

        Mockito.verify(movieRepository).getAllNowPlayingMovies()
        Mockito.verifyNoMoreInteractions(movieRepository)

    }

}