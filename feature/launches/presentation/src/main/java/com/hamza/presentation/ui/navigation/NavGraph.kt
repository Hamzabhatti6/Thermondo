package com.hamza.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hamza.presentation.ui.composable.LaunchesDetailScreen
import com.hamza.presentation.ui.composable.LaunchesScreen
import com.hamza.presentation.ui.viewmodel.LaunchesViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: LaunchesViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    )
    {
        composable(route = Screens.Home.route) {
            LaunchesScreen(navController, viewModel)
        }
        composable(
            route = Screens.LaunchesDetail.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )
        ) { entry ->
            /* Extracting the id from the route */
            val id = entry.arguments?.getString("id")
            id?.let {
                LaunchesDetailScreen(
                    navController = navController,
                    viewModel,
                    id
                )
            }
        }
    }
}