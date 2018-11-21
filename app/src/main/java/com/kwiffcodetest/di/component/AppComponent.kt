package com.kwiffcodetest.di.component

import com.kwiffcodetest.KwiffApplication
import com.kwiffcodetest.di.module.AppModule
import com.kwiffcodetest.di.module.NetworkModule
import com.kwiffcodetest.di.module.PicassoModule
import com.kwiffcodetest.ui.moviedetail.MovieDetailActivity
import com.kwiffcodetest.ui.movielist.MovieListActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by David C. on 21/11/2018.
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, PicassoModule::class])
interface AppComponent {

    fun inject(app: KwiffApplication)
    fun inject(movieListActivity: MovieListActivity)
    fun inject(movieDetailActivity: MovieDetailActivity)

}