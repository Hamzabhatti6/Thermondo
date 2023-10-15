package com.hamza.domain.di

import com.hamza.api.repo.LaunchesRepository
import com.hamza.api.usecase.LaunchesUseCase
import com.hamza.domain.repo.LaunchesRepositoryImpl
import com.hamza.domain.usecase.LaunchesUseCaseImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val launchesDomainModule = module {
    single<LaunchesRepository> { LaunchesRepositoryImpl(get()) }
    single<LaunchesUseCase> { LaunchesUseCaseImpl(coroutineContext = Dispatchers.IO, get()) }
}