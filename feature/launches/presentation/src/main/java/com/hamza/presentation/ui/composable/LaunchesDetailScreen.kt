package com.hamza.presentation.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.hamza.presentation.R
import com.hamza.presentation.ui.data.LaunchesDetailsUiModel
import com.hamza.presentation.ui.utils.MyAppBar
import com.hamza.presentation.ui.viewmodel.LaunchesViewModel

@Composable
fun LaunchesDetailScreen(
    navController: NavController,
    viewModel: LaunchesViewModel,
    id: String
) {

    viewModel.fetchDetails(id)
    val launch by viewModel.launchesDetails.collectAsState()

    Scaffold(
        topBar = {
            MyAppBar(
                navController = navController, onBackPressed = {
                    navController.navigateUp()
                })
        },
        content = { paddingValue ->
            Column(
                modifier = Modifier
                    .padding(paddingValue)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                launch?.let { launch ->
                    LaunchesDetail(launch = launch)
                    FavoriteButton(onClick = {
                        viewModel.markFavourite(launch.id)
                    } )
                }

            }
        }
    )
}

@Composable
fun LaunchesDetail(launch: LaunchesDetailsUiModel) {
    Column {
        AsyncImage(
            model = launch.largeLink,
            contentDescription = stringResource(R.string.icon),
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Row (modifier = Modifier
            .padding(top = 50.dp)){

            Text(
                text = stringResource(R.string.id),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = launch.id,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        Row {
            Text(
                text = stringResource(R.string.detail),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = launch.details,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)

            )
        }

        Row {
            Text(
                text = stringResource(R.string.rocket),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = launch.rocket,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)

            )
        }

        Row {
            Text(
                text = stringResource(R.string.flight_number),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = launch.flight_number.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)

            )
        }
    }

}

@Composable
fun FavoriteButton(onClick : () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            onClick()
        },
            modifier = Modifier.padding(20.dp),
            enabled = true,

            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
            shape = MaterialTheme.shapes.medium,
            ) {
            Text(text = stringResource(id = R.string.mark_favorite), color = Color.White)
        }
     
    }
}

