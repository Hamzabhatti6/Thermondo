package com.hamza.domain.worker

import com.hamza.api.Launches
import com.hamza.api.worker.UpdateWorker
import com.hamza.domain.extention.toLaunchEto
import com.hamza.local.dao.LaunchDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class UpdateWorkerImpl(
    private val coroutineContext: CoroutineContext = Dispatchers.IO,
    private val dao: LaunchDao,
    private val launch: Launches,
): UpdateWorker {
    override suspend fun doWork() {
           processData()
    }

    private suspend fun processData() {
        withContext(coroutineContext) {
            try {
                dao.insertItem(launch.toLaunchEto())
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
    }
}