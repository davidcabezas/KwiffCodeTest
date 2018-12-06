package com.kwiffcodetest.di.module

import com.kwiffcodetest.scheduler.BaseSchedulerProvider
import com.kwiffcodetest.ui.moviedetail.MovieDetailInteractor
import com.kwiffcodetest.ui.moviedetail.MovieDetailPresenter
import com.kwiffcodetest.ui.moviedetail.MovieDetailPresenterImpl
import com.kwiffcodetest.ui.movielist.MovieListInteractor
import com.kwiffcodetest.ui.movielist.MovieListPresenter
import com.kwiffcodetest.ui.movielist.MovieListPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by David C. on 21/11/2018.
 */
@Module(includes = [InteractorModule::class, SchedulerModule::class])
class AppModule() {

    @Provides
    @Singleton
    fun movieListPresenter(movieListInteractor: MovieListInteractor, scheduler: BaseSchedulerProvider): MovieListPresenter =
            MovieListPresenterImpl(movieListInteractor, scheduler)


    @Provides
    fun movieDetailPresenter(movieDetailInteractor: MovieDetailInteractor, scheduler: BaseSchedulerProvider): MovieDetailPresenter =
            MovieDetailPresenterImpl(movieDetailInteractor, scheduler)

}