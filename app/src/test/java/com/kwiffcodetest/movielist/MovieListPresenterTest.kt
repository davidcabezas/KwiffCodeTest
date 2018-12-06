package com.kwiffcodetest.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.data.Results
import com.kwiffcodetest.scheduler.TrampolineSchedulerProvider
import com.kwiffcodetest.ui.movielist.MovieListInteractor
import com.kwiffcodetest.ui.movielist.MovieListPresenter
import com.kwiffcodetest.ui.movielist.MovieListPresenterImpl
import com.kwiffcodetest.ui.movielist.MovieListView
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyList
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by David C. on 22/11/2018.
 */
class MovieListPresenterTest {

    private lateinit var presenter: MovieListPresenter

    @Mock
    private lateinit var interactor: MovieListInteractor

    @Mock
    private lateinit var view: MovieListView

    private var schedulerProvider = TrampolineSchedulerProvider()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = MovieListPresenterImpl(interactor, schedulerProvider)
        presenter.attach(view)
    }

    @Test
    fun getAllMoviesNoResults() {

        val list = mutableListOf<Movie>()
        list.add(Movie(0, "Title", 0.0, "Overview", "", "", null))
        list.add(Movie(1, "Title", 0.0, "Overview", "", "", null))
        list.add(Movie(2, "Title", 0.0, "Overview", "", "", null))

        val results = Results(list.toList())

        whenever(interactor.getMovieList()).thenReturn(Single.just(results))

        runBlocking { presenter.getAllMovies() }

        verify(view, times(1)).printMovieList(anyList())
    }

}