package com.hamza.domain.repo

import com.hamza.api.Launches
import com.hamza.api.repo.LaunchesRepository
import com.hamza.domain.extention.toLaunches
import com.hamza.network.ApiService

class LaunchesRepositoryImpl(private val apiService: ApiService): LaunchesRepository {
    override suspend fun fetchLaunches(): List<Launches> {
        return apiService.fetchLaunches().toLaunches()
    }
}