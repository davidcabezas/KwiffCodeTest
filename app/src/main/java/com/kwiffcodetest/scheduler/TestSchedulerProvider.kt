package com.kwiffcodetest.scheduler

import io.reactivex.schedulers.TestScheduler

/**
 * Created by David C. on 06/12/2018.
 */
class TestSchedulerProvider(private val scheduler: TestScheduler) : BaseSchedulerProvider {
    override fun computation() = scheduler
    override fun ui() = scheduler
    override fun io() = scheduler
}