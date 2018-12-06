package com.kwiffcodetest.ui.movielist

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.scheduler.BaseSchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieListPresenterImpl
@Inject constructor(
    private val movieListInteractor: MovieListInteractor,
    private val schedulerProvider: BaseSchedulerProvider
) : MovieListPresenter {

    private var view: MovieListView? = null
    private val subscriptions = CompositeDisposable()

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

    override fun getAllMovies() {

        view?.showProgress(true)

        val subscribe = movieListInteractor.getMovieList()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                { result ->
                    view?.showProgress(false)
                    view?.printMovieList(result.results)
                }, { error ->
                    view?.showProgress(false)
                    view?.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)

    }

    override fun manageItemClick(movie: Movie) {
        view?.showMovieDetailsView(movie.id)
    }
}