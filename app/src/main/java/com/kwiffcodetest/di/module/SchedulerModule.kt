package com.kwiffcodetest.di.module

import com.kwiffcodetest.scheduler.BaseSchedulerProvider
import com.kwiffcodetest.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by David C. on 06/12/2018.
 */
@Module
class SchedulerModule {

    @Provides
    @Singleton
    fun scheduler(): BaseSchedulerProvider = SchedulerProvider()

}