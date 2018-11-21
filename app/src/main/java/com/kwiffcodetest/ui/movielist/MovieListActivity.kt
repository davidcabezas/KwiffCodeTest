package com.kwiffcodetest.ui.movielist

import android.os.Bundle
import com.kwiffcodetest.R
import com.kwiffcodetest.ui.base.BaseActivity
import javax.inject.Inject

class MovieListActivity : BaseActivity(), MovieListView {

    @Inject
    lateinit var presenter: MovieListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        appComponent.inject(this)

        presenter.attach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
        presenter.detach()
    }
}
