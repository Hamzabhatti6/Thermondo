package com.hamza.domain.usecase

import com.hamza.api.repo.LaunchesRepository
import com.hamza.api.usecase.LaunchesUseCase
import com.hamza.api.usecase.LaunchesUseCaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class LaunchesUseCaseImpl(
    private val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val launchesRepository: LaunchesRepository
) : LaunchesUseCase {
    override suspend fun invoke(): LaunchesUseCaseResult {
        return withContext(coroutineContext) {
            try {
                val launches = launchesRepository.fetchLaunches()

                LaunchesUseCaseResult.Success(launches.take(50))
            } catch (e: Exception) {
                LaunchesUseCaseResult.Error(e.cause)
            }
        }
    }
}