package com.kwiffcodetest.ui.movielist

import android.support.v7.widget.RecyclerView
import android.view.View
import com.kwiffcodetest.data.Movie
import com.kwiffcodetest.util.Constants
import com.kwiffcodetest.util.SharedViewData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_movie_item.view.*

/**
 * Created by David C. on 21/11/2018.
 */
class MovieViewHolder (itemView: View, val picasso: Picasso) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie, clickListener: MovieListAdapter.OnItemClickListener) {
        picasso.load(Constants.BASE_IMAGE_URL + movie.posterPath).into(itemView.imageView_movie_item)
        itemView.setOnClickListener { clickListener.onItemClick(movie, SharedViewData(itemView.imageView_movie_item)) }
    }

}