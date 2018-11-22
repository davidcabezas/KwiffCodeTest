package com.kwiffcodetest

import org.junit.rules.TestRule
import org.mockito.MockitoAnnotations

/**
 * Created by David C. on 22/11/2018.
 */
class InjectMocksRule {

    companion object {
        fun create(testClass: Any) = TestRule { statement, _ ->
            MockitoAnnotations.initMocks(testClass)
            statement
        }
    }
}