package com.kwiffcodetest.data

import com.google.gson.annotations.SerializedName

/**
 * Created by David C. on 21/11/2018.
 */
data class Movie(val id: Int, val title: String, @SerializedName("vote_average") val voteAverage: Double, val overview: String, @SerializedName("release_date") val releaseDate: String, @SerializedName("poster_path") val posterPath: String, @SerializedName("belongs_to_collection") val belongsToCollection: Collection?)