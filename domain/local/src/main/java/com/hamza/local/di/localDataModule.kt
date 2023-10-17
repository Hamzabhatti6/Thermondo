package com.hamza.local.di

import androidx.room.Room
import com.hamza.local.dao.LaunchDao
import com.hamza.local.db.DB_NAME
import com.hamza.local.db.LaunchDatabase
import org.koin.dsl.module

val localDataModule = module {
    single<LaunchDatabase> {
        Room.databaseBuilder(
            get(),
            LaunchDatabase::class.java,
            DB_NAME
        ).build()
    }

    single<LaunchDao> {
        get<LaunchDatabase>().LaunchDao()
    }
}