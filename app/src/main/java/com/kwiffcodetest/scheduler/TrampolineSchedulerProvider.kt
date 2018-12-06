package com.kwiffcodetest.scheduler

import io.reactivex.schedulers.Schedulers

/**
 * Created by David C. on 06/12/2018.
 */
class TrampolineSchedulerProvider : BaseSchedulerProvider {
    override fun computation() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
}