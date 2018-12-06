package com.kwiffcodetest.ui.moviedetail

import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.scheduler.BaseSchedulerProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by David C. on 21/11/2018.
 */
class MovieDetailPresenterImpl
@Inject constructor(
    private val movieDetailInteractor: MovieDetailInteractor,
    private val schedulerProvider: BaseSchedulerProvider
) : MovieDetailPresenter {

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

        view?.showProgress(true)

        val subscribe = movieDetailInteractor.getMovieDetails(movieId)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(
                { movie ->
                    view?.showProgress(false)
                    view?.printMovieDetails(movie)

                    if (movie.belongsToCollection != null) {
                        view?.showCollectionLayout(true)
                        getMovieCollection(movie.belongsToCollection.id)
                    } else {
                        view?.showCollectionLayout(false)
                    }

                }, { error ->
                    view?.showProgress(false)
                    view?.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)

    }

    override fun manageItemClick(movie: Movie) {
        view?.showMovieDetailsView(movie.id)
    }

    // This function is private and called only prom the presenter itself because the View doesn't
    // need to call method directly
    private fun getMovieCollection(collectionId: Int) {

        view?.showCollectionProgress(true)

        val subscribe = movieDetailInteractor.getMovieCollection(collectionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { list ->
                    view?.showCollectionProgress(false)
                    view?.printCollection(list.parts!!)

                }, { error ->
                    view?.showCollectionProgress(false)
                    view?.showErrorMessage(error.localizedMessage)
                })

        subscriptions.add(subscribe)

    }

}