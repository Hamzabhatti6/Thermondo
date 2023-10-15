package com.hamza.domain.usecase

import com.hamza.api.Launches
import com.hamza.api.usecase.LaunchesUseCase
import com.hamza.api.usecase.LaunchesUseCaseResult
import io.mockk.MockKAnnotations
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LaunchesUseCaseImplTest {

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `verify success` () = runBlocking {
        val mockLaunches = listOf(mockk<Launches>())
        val useCase = object : LaunchesUseCase {
            override suspend fun invoke(): LaunchesUseCaseResult = LaunchesUseCaseResult.Success(mockLaunches)
        }

        val result = useCase()

        assertEquals(LaunchesUseCaseResult.Success(mockLaunches), result)
    }

    @Test
    fun `verify error`() = runBlocking {
        val errorMessage = "An error occurred"
        val throwable = Throwable(errorMessage)
        val useCase = object : LaunchesUseCase {
            override suspend fun invoke(): LaunchesUseCaseResult = LaunchesUseCaseResult.Error(throwable)
        }

        val result = useCase()

        assertEquals(LaunchesUseCaseResult.Error(throwable), result)
    }
}