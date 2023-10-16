package com.hamza.presentation.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.hamza.common.AppTheme
import com.hamza.presentation.ui.composable.LaunchesScreen
import com.hamza.presentation.ui.navigation.ComposeNavigation
import com.hamza.presentation.ui.viewmodel.LaunchesViewModel
import org.koin.android.ext.android.inject

class LaunchesActivity : AppCompatActivity() {

    private val viewModel by inject<LaunchesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ComposeNavigation(viewModel)
                LaunchesScreen(viewModel)
            }
        }
    }
}