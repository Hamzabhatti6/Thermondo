package com.hamza.presentation.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hamza.presentation.R
import com.hamza.presentation.ui.data.LaunchesUiModel
import com.hamza.presentation.ui.viewmodel.LaunchesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchesScreen(viewModel: LaunchesViewModel) {

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
        val scaffoldState = rememberBottomSheetScaffoldState()

        val detail by viewModel.launchesDetails.collectAsState()
        if (detail != null) {
            LaunchesDetailScreen(
                detail = detail!!
            )
            LaunchedEffect(key1 = null) {
                scaffoldState.bottomSheetState.expand()
            }
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

@Composable
fun LaunchesCard(launch: LaunchesUiModel, onItemClick: (id: String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, end = 8.dp)
            .clickable {
                onItemClick(launch.id)
            }

    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = launch.id,
                fontSize = 12.sp,
                maxLines = 1,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(8.dp)
            )
        }

        AsyncImage(
            model = launch.smallLink,
            contentDescription = stringResource(R.string.icon),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}