package com.kwiffcodetest.ui.moviedetail

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieDetailPresenterImpl
@Inject constructor(private val movieDetailInteractor: MovieDetailInteractor) : MovieDetailPresenter {

    private var view: MovieDetailView? = null
    private val subscriptions = CompositeDisposable()

    override fun subscribe() {
        // Not used in this code test
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MovieDetailView) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    override fun getMovieDetails(movieId: Int) {
        movieDetailInteractor

        view?.showProgress(true)

        val subscribe = movieDetailInteractor.getMovieDetails(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { movie ->
                            view?.showProgress(false)
                            view?.printMovieDetails(movie)
                        }, { error ->
                    view?.showProgress(false)
                    view?.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)
    }
}