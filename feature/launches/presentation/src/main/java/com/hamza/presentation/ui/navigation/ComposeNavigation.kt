package com.hamza.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hamza.presentation.ui.composable.LaunchesDetailScreen
import com.hamza.presentation.ui.composable.LaunchesScreen
import com.hamza.presentation.ui.viewmodel.LaunchesViewModel

@Composable
fun ComposeNavigation(viewModel: LaunchesViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            LaunchesScreen(viewModel)
        }
        composable("Detail"){
         //   LaunchesDetailScreen()
        }
    }

}
