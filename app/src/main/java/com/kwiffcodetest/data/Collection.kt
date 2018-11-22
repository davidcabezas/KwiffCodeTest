package com.kwiffcodetest.data

import com.google.gson.annotations.SerializedName

/**
 * Created by David C. on 22/11/2018.
 */
data class Collection(val id: Int, val name: String, @SerializedName("poster_path") val posterPath: String, @SerializedName("backdrop_path") val backdropPath: String, val parts: List<Movie>?)