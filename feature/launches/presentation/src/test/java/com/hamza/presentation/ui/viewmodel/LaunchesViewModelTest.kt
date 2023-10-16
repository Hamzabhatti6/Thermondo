package com.hamza.presentation.ui.viewmodel

import app.cash.turbine.test
import com.hamza.api.Launches
import com.hamza.api.usecase.LaunchesUseCase
import com.hamza.api.usecase.LaunchesUseCaseResult
import com.hamza.framework.ViewModelBaseTest
import com.hamza.presentation.ui.data.toLaunchesDetailsModel
import com.hamza.presentation.ui.data.toListLaunchesUiModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LaunchesViewModelTest : ViewModelBaseTest(){

    private lateinit var getLaunchesUseCase: LaunchesUseCase

    private lateinit var viewModel: LaunchesViewModel

    @Before
    fun setup() {
        super.setUpBase()
      //  MockitoAnnotations.initMocks(this)
        getLaunchesUseCase = mockk<LaunchesUseCase>()
        viewModel = LaunchesViewModel(getLaunchesUseCase)

    }

    @Test
    fun `verify list is loaded`() = runBlocking {
        coEvery { getLaunchesUseCase.invoke() } returns LaunchesUseCaseResult.Success(launches = emptyList())

        viewModel.loadLaunches()
        assertEquals(emptyList<Launches>(), viewModel.launches)
    }

    @Test
    fun `verify data is loaded and mapped to UI Model`() = runTest {
        val launches = listOf<Launches>(
            mockk(relaxed = true)
        )
        coEvery { getLaunchesUseCase() } returns LaunchesUseCaseResult.Success(
            launches =  launches
        )

        viewModel.launches.test {
            val state = awaitItem()
            assertEquals(false, state.isLoading)
            assertEquals(false, state.isError)
            assertEquals(null, state.errorMessage)
            assertEquals(launches.toListLaunchesUiModel(), state.launches)
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `verify error is happened while loading`() = runTest {
        val errorMessage = "An error occurred"
        coEvery { getLaunchesUseCase() } returns LaunchesUseCaseResult.Error(Throwable(errorMessage))

        viewModel.launches.test {
            val state = awaitItem()
            assertEquals(false, state.isLoading)
            assertEquals(true, state.isError)
            assertEquals(errorMessage, state.errorMessage)
            assertTrue(state.launches.isEmpty())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `verify error is happened while loading and retry success `() = runTest {
        val errorMessage = "An error occurred"
        coEvery { getLaunchesUseCase() } returns LaunchesUseCaseResult.Error(Throwable(errorMessage))

        viewModel.launches.test {
            val state = awaitItem()
            assertEquals(false, state.isLoading)
            assertEquals(true, state.isError)
            assertEquals(errorMessage, state.errorMessage)
            assertTrue(state.launches.isEmpty())
            cancelAndConsumeRemainingEvents()
        }

        val launches = listOf<Launches>(
            mockk(relaxed = true)
        )
        coEvery { getLaunchesUseCase() } returns LaunchesUseCaseResult.Success(
            launches =  launches
        )

        viewModel.retry()

        viewModel.launches.test {
            val state = awaitItem()
            assertEquals(false, state.isLoading)
            assertEquals(false, state.isError)
            assertEquals(null, state.errorMessage)
            assertEquals(launches.toListLaunchesUiModel(), state.launches)
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `verify launches data is loaded for specific launches id`() = runTest {
        val launchesId = "5eb87cd9ffd86e000604b32a"
        val rocket = "5e9d0d95eda69955f709d1eb"
        val launch = listOf<Launches>(
            mockk<Launches>(relaxed = true).copy(
                rocket = rocket,
                details = "",
                id = launchesId,
                flight_number = 1,
                auto_update = true,
                links = mockk()
            )
        )
        coEvery { getLaunchesUseCase.invoke() } returns LaunchesUseCaseResult.Success(
            launches =  launch
        )

        viewModel.fetchDetails(launchesId)

        viewModel.launchesDetails.test {
            val item = awaitItem()
            assertEquals(launch.first().toLaunchesDetailsModel(), item)
            cancelAndConsumeRemainingEvents()
        }

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }
}