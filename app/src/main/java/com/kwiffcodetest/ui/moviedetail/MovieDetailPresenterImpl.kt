package com.kwiffcodetest.ui.moviedetail

import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieDetailPresenterImpl
    @Inject constructor(private val movieDetailInteractor: MovieDetailInteractor): MovieDetailPresenter {

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
}