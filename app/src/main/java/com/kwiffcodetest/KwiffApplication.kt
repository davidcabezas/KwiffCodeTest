package com.kwiffcodetest

import android.app.Application
import com.kwiffcodetest.di.component.AppComponent
import com.kwiffcodetest.di.component.DaggerAppComponent
import com.kwiffcodetest.di.module.ContextModule

/**
 * Created by David C. on 21/11/2018.
 */
class KwiffApplication : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder().contextModule(ContextModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)

    }

}