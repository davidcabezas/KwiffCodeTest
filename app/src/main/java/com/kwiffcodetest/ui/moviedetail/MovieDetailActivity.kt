package com.kwiffcodetest.ui.moviedetail

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.kwiffcodetest.R
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.ui.base.BaseActivity
import com.kwiffcodetest.ui.movielist.MovieListAdapter
import com.kwiffcodetest.util.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), MovieDetailView, MovieListAdapter.OnItemClickListener {

    @Inject
    lateinit var presenter: MovieDetailPresenter

    @Inject
    lateinit var picasso: Picasso

    private var movieId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        appComponent.inject(this)

        presenter.attach(this)

        if (intent.hasExtra(Constants.MOVIE_ID)) {
            movieId = intent.getSerializableExtra(Constants.MOVIE_ID) as Int

            loadMovieDetail()
        } else {
            Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show()
            finish()
        }
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
        picasso.load(Constants.BASE_IMAGE_URL + movie.posterPath).into(imageView_movie_poster)
        textView_movie_detail_title.text = movie.title
        textView_movie_detail_overview.text = "${resources.getString(R.string.overview)}: ${movie.overview}"
        textView_movie_detail_release_date.text = "${resources.getString(R.string.release_date)}: ${movie.releaseDate}"
    }

    override fun printCollection(movieList: List<Movie>) {

        val moviesAdapter = MovieListAdapter(this, picasso)
        moviesAdapter.movieList = movieList

        recyclerView_collection.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_collection.adapter = moviesAdapter

        scrollView.fullScroll(View.FOCUS_DOWN)

    }

    override fun onItemClick(item: Movie) = presenter.manageItemClick(item)

    override fun showMovieDetailsView(movieId: Int) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(Constants.MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun showCollectionLayout(show: Boolean) {
        layout_collection.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showProgress(show: Boolean) {
        loading!!.visibility = if (show) View.VISIBLE else View.GONE
        layout_container!!.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun showCollectionProgress(show: Boolean) {
        loading_collection!!.visibility = if (show) View.VISIBLE else View.GONE
        recyclerView_collection!!.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun showErrorMessage(message: String) =
            notifyWithAction(this.findViewById(R.id.layout_main), message, R.string.retry, ::loadMovieDetail)
}
