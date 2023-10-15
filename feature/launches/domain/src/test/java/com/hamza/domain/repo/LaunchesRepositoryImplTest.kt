package com.hamza.domain.repo

import com.hamza.api.repo.LaunchesRepository
import com.hamza.network.ApiService
import com.hamza.network.model.LaunchesDto
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class LaunchesRepositoryImplTest {

    @MockK
    private lateinit var apiService: ApiService
    private lateinit var repository: LaunchesRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = LaunchesRepositoryImpl(apiService)
    }

    @Test
    fun `verify Launches list call`() = runBlocking {
        coEvery { apiService.fetchLaunches() } returns listOf(mockk<LaunchesDto>(relaxed = true))
        repository.fetchLaunches()

        coVerify { apiService.fetchLaunches() }
    }
}