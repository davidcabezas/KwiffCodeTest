package com.kwiffcodetest.di.module

import com.kwiffcodetest.retrofit.MovieApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by David C. on 22/11/2018.
 */
@Module(includes = [NetworkModule::class])
class ApiModule {

    @Provides
    @Singleton
    fun movieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

}