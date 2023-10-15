package com.hamza.presentation.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hamza.presentation.R
import com.hamza.presentation.ui.data.LaunchesDetailsUiModel

@Composable
fun LaunchesDetailScreen(detail: LaunchesDetailsUiModel) {

    Scaffold(
        content = { paddingValue ->
            Column(
                modifier = Modifier
                    .padding(paddingValue)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LaunchesDetail(launch = detail)
            }
        }

    )
}

    @Composable
    fun LaunchesDetail(launch: LaunchesDetailsUiModel) {
        Column() {
            Row {

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
                    modifier = Modifier.padding(end = 8.dp)
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
                    modifier = Modifier.padding(end = 8.dp)
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
                    modifier = Modifier.padding(end = 8.dp)
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
                    modifier = Modifier.padding(end = 8.dp)
                        .align(Alignment.CenterVertically)

                )
            }

            AsyncImage(
                model = launch.largeLink,
                contentDescription = stringResource(R.string.icon),
                modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

