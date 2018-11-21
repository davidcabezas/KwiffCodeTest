package com.kwiffcodetest.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by David C. on 21/11/2018.
 */
@Module
class ContextModule(private val context: Context) {

    @Provides
    @Singleton
    fun context(): Context = this.context

}