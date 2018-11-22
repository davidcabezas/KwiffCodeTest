package com.kwiffcodetest.ui.movielist

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kwiffcodetest.R
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.extension.inflate
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

/**
 * Created by David C. on 21/11/2018.
 */
class MovieListAdapter(val listener: OnItemClickListener, val picasso: Picasso) : RecyclerView.Adapter<MovieViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Movie)
    }

    internal var movieList: List<Movie> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder = MovieViewHolder(parent.inflate(R.layout.row_movie_item), picasso)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.bind(movieList[position], listener)

    override fun getItemCount(): Int = movieList.size

}