package com.hamza.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hamza.local.dao.LaunchDao
import com.hamza.local.entities.LaunchEto

@Database(entities = [LaunchEto::class], version = 1, exportSchema = false)
abstract class LaunchDatabase : RoomDatabase() {
    abstract fun LaunchDao(): LaunchDao
}

internal const val DB_NAME = "launch_database"