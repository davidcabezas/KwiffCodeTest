package com.kwiffcodetest.scheduler

import io.reactivex.Scheduler

/**
 * Created by David C. on 06/12/2018.
 */
interface BaseSchedulerProvider {

    fun io(): Scheduler
    fun computation(): Scheduler
    fun ui(): Scheduler

}