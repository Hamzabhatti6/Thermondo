package com.hamza.domain.repo

import com.hamza.local.dao.LaunchDao
import com.hamza.local.entities.LaunchEto
import com.hamza.local.repo.LaunchesDatabaseRepo

class LaunchesDbRepoImpl(
    private val localDb: LaunchDao
): LaunchesDatabaseRepo {
    override suspend fun fetchLaunches(): List<LaunchEto> {
        return localDb.getAll()
    }
    override suspend fun addFavourite(item: LaunchEto) {
        localDb.insertItem(item)
    }
}