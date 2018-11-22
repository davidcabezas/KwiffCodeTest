package com.kwiffcodetest.movielist

import com.kwiffcodetest.ui.movielist.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by David C. on 22/11/2018.
 */
class MovieListPresenterTest { // Test not finished (run out of time)

    private lateinit var presenter: MovieListPresenter

    @Mock
    private lateinit var interactor: MovieListInteractor

    private lateinit var view: MovieListView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        view = Mockito.spy(MovieListActivity())

        presenter = Mockito.spy(MovieListPresenterImpl(interactor))
        presenter.attach(view)
    }

    @Test
    fun getAllMoviesNoResults() {

        presenter.getAllMovies()

        Mockito.verify(interactor, Mockito.times(1)).getMovieList()
    }

}