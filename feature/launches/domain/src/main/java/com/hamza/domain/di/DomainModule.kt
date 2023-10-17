package com.hamza.domain.di

import com.hamza.api.repo.LaunchesRepository
import com.hamza.api.usecase.LaunchesUseCase
import com.hamza.api.usecase.MarkFavoritesUseCase
import com.hamza.domain.repo.LaunchesDbRepoImpl
import com.hamza.domain.repo.LaunchesRepositoryImpl
import com.hamza.domain.usecase.LaunchesUseCaseImpl
import com.hamza.domain.usecase.MarkFavoritesUseCaseImpl
import com.hamza.local.repo.LaunchesDatabaseRepo
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val launchesDomainModule = module {
    single<LaunchesRepository> { LaunchesRepositoryImpl(get()) }
    single<LaunchesUseCase> { LaunchesUseCaseImpl(coroutineContext = Dispatchers.IO, get()) }
    single<MarkFavoritesUseCase> { MarkFavoritesUseCaseImpl(coroutineContext = Dispatchers.IO, get()) }
    single<LaunchesDatabaseRepo> { LaunchesDbRepoImpl(get()) }
}