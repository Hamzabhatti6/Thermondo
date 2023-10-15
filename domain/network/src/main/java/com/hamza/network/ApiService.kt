package com.hamza.network

import com.hamza.network.model.LaunchesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("launches")
    suspend fun fetchLaunches(): List<LaunchesDto>
}