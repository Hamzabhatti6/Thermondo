package com.hamza.local.repo

import com.hamza.local.entities.LaunchEto

interface LaunchesDatabaseRepo {
    suspend fun fetchLaunches(): List<LaunchEto>
    suspend fun addFavourite(item: LaunchEto)

}