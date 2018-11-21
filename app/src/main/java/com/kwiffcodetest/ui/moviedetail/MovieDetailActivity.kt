package com.kwiffcodetest.ui.moviedetail

import android.os.Bundle
import com.kwiffcodetest.R
import com.kwiffcodetest.ui.base.BaseActivity
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), MovieDetailView {

    @Inject
    lateinit var presenter: MovieDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        appComponent.inject(this)

        presenter.attach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
        presenter.detach()
    }
}
