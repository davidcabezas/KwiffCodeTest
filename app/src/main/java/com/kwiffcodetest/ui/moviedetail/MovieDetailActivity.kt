package com.kwiffcodetest.ui.moviedetail

import android.os.Bundle
import com.kwiffcodetest.R
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BaseActivity
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), MovieDetailView {

    @Inject
    lateinit var presenter: MovieDetailPresenter

    private var movieId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        appComponent.inject(this)

        presenter.attach(this)
    }

    private fun loadMovieDetail() {
        presenter.getMovieDetails(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
        presenter.detach()
    }

    override fun printMovieDetails(movie: Movie) {
        // Fill view with Movie details
    }

    override fun showProgress(show: Boolean) {
        ;
    }

    override fun showErrorMessage(message: String) =
            notifyWithAction(this.findViewById(R.id.layout_main), message, R.string.retry, ::loadMovieDetail)
}
