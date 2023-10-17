package com.hamza.local.dao

import androidx.room.*
import com.hamza.local.entities.LaunchEto

@Dao
interface LaunchDao {
    @Query("SELECT * FROM LaunchEto")
    suspend fun getAll(): List<LaunchEto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(vararg launchEto: LaunchEto)

    @Delete
    suspend fun delete(launchEto: LaunchEto)
}