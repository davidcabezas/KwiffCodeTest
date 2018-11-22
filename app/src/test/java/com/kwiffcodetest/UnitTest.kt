package com.kwiffcodetest

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by David C. on 22/11/2018.
 */
@RunWith(MockitoJUnitRunner::class)
abstract class UnitTest {

    @Suppress("LeakingThis")
    @Rule
    @JvmField val injectMocks = InjectMocksRule.create(this@UnitTest)
}