package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieListPresenterImpl
    @Inject constructor(private val movieListInteractor: MovieListInteractor): MovieListPresenter {

    private var view: MovieListView? = null
    private val subscriptions = CompositeDisposable()

    override fun getAllMovies() {
        ;
    }

    override fun manageItemClick(movie: Movie) {
        ;
    }

    override fun subscribe() {
        // Not used in this code test
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MovieListView) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}