package com.hamza.presentation.di

import com.hamza.presentation.ui.viewmodel.LaunchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val launchesModule = module {
    viewModel { LaunchesViewModel(get()) }
}