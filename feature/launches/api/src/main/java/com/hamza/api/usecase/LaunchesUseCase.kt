package com.hamza.api.usecase

import com.hamza.api.Launches

interface LaunchesUseCase {
    suspend operator fun invoke(): LaunchesUseCaseResult
}
sealed class LaunchesUseCaseResult {
    data class Success(val launches: List<Launches>): LaunchesUseCaseResult()
    data class Error(val throwable: Throwable?): LaunchesUseCaseResult()
}