package com.hamza.framework

import androidx.annotation.CallSuper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.mockito.MockitoAnnotations

open class AppBaseTest{
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutineRule()


    @CallSuper
    @Throws(Exception::class)
    protected fun setUpBase() {
        MockitoAnnotations.initMocks(this)
    }
}