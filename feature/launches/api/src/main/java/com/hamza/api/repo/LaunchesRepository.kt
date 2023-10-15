package com.hamza.api.repo

import com.hamza.api.Launches

interface LaunchesRepository {
    suspend fun fetchLaunches(): List<Launches>
}