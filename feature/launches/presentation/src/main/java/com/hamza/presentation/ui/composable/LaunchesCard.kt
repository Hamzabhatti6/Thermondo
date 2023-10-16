package com.hamza.presentation.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
import com.hamza.presentation.ui.data.LaunchesUiModel

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