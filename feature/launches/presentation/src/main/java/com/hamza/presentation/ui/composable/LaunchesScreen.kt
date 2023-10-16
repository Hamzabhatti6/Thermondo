package com.hamza.presentation.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hamza.presentation.ui.data.LaunchesUiModel
import com.hamza.presentation.ui.viewmodel.LaunchesViewModel

@Composable
fun LaunchesScreen(navController: NavHostController, viewModel: LaunchesViewModel
) {

    val launchesState by viewModel.launches.collectAsState()

    // Simulate loading state
    val isLoading by rememberUpdatedState(newValue = launchesState.isLoading)
    val isError by rememberUpdatedState(newValue = launchesState.isError)
    val errorMessage by rememberUpdatedState(newValue = launchesState.errorMessage)

    Scaffold(
    content = { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                if (isError) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Snackbar(
                            modifier = Modifier.padding(16.dp),
                            action = {
                                TextButton(
                                    onClick = {
                                        viewModel.retry()
                                    }
                                ) {
                                    Text(text = "Retry")
                                }
                            }
                        ) {
                            Text(text = errorMessage ?: "An error occurred")
                        }
                    }
                }
                else {
                    LaunchesList(launches = launchesState.launches, onItemClick = {
                        viewModel.fetchDetails(it)
                    })
                }
            }

        }

        val detail by viewModel.launchesDetails.collectAsState()
        if (detail != null) {
            LaunchesDetailScreen(
                navController,
                detail = detail!!
            )

        }
    }
    )
}

@Composable
fun LaunchesList(launches: List<LaunchesUiModel>,  onItemClick: (id: String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
        items(items = launches) { item ->
            LaunchesCard(launch = item, onItemClick = onItemClick)
        }
    }
}

