package com.hamza.domain.usecase

import com.hamza.api.Launches
import com.hamza.api.usecase.MarkFavoritesUseCase
import com.hamza.local.entities.LaunchEto
import com.hamza.local.repo.LaunchesDatabaseRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MarkFavoritesUseCaseImpl(
    private val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val launchesDbRepoImpl: LaunchesDatabaseRepo
): MarkFavoritesUseCase {
    override suspend fun invoke(item: Launches) {
        withContext(coroutineContext) {
            launchesDbRepoImpl.addFavourite(item.toEto())
        }
    }
}

private fun Launches.toEto(): LaunchEto {
    return LaunchEto(this.id!!, this.details.let { it ?: "" }, this.rocket!!, this.flight_number!!,this.links?.patch?.large!!)
}