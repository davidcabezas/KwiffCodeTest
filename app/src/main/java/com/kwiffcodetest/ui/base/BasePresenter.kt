package com.kwiffcodetest.ui.base

/**
 * Created by David C. on 21/11/2018.
 */
interface BasePresenter<in T> {

    fun subscribe()
    fun unsubscribe()
    fun attach(view: T)
    fun detach()

}