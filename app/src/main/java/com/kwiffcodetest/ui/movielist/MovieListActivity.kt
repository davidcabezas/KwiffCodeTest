package com.kwiffcodetest.ui.movielist

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.kwiffcodetest.R
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BaseActivity
import com.kwiffcodetest.ui.moviedetail.MovieDetailActivity
import com.kwiffcodetest.util.Constants
import com.kwiffcodetest.util.SharedViewData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

class MovieListActivity : BaseActivity(), MovieListView, MovieListAdapter.OnItemClickListener {

    @Inject
    lateinit var presenter: MovieListPresenter

    @Inject
    lateinit var picasso: Picasso

    private lateinit var moviesAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        appComponent.inject(this)

        presenter.attach(this)

        initializeView()

        loadMovieList()
    }

    private fun initializeView() {

        moviesAdapter = MovieListAdapter(this, picasso)

        recyclerView_items_list.layoutManager = GridLayoutManager(this, 2)
        recyclerView_items_list.adapter = moviesAdapter

    }

    private fun loadMovieList() = presenter.getAllMovies()

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
        presenter.detach()
    }

    override fun printMovieList(movieList: List<Movie>) {
        moviesAdapter.movieList = movieList
    }

    override fun onItemClick(item: Movie, sharedViewData: SharedViewData) = presenter.manageItemClick(item, sharedViewData)

    override fun showMovieDetailsView(movieId: Int, sharedViewData: SharedViewData) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(Constants.MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun showProgress(show: Boolean) {
        loading!!.visibility = if (show) View.VISIBLE else View.GONE
        recyclerView_items_list!!.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun showErrorMessage(message: String) =
            notifyWithAction(this.findViewById(R.id.layout_main), message, R.string.retry, ::loadMovieList)
}
