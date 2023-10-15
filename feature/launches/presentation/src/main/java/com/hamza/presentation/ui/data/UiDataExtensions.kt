package com.hamza.presentation.ui.data

import com.hamza.api.Launches

fun Launches.toUiModel() : LaunchesUiModel {
    return LaunchesUiModel(
        id = this.id!!,
        smallLink = this.links!!.patch.small!!)
}

fun List<Launches>.toListLaunchesUiModel(): List<LaunchesUiModel> {
    return this.map { it.toUiModel() }
}

fun Launches.toLaunchesDetailsModel(): LaunchesDetailsUiModel {
    return LaunchesDetailsUiModel(
        rocket = this.rocket!!,
        details = this.details!!,
        id = this.id!!,
        flight_number = this.flight_number!!,
        auto_update = this.auto_update!!,
        largeLink = this.links!!.patch.large!!
    )
}