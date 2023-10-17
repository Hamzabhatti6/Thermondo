package com.hamza.presentation.ui.data

import com.hamza.api.Launches
import com.hamza.local.entities.LaunchEto

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
        rocket = this.rocket.toString(),
        details = this.details.toString(),
        id = this.id.toString(),
        flight_number = this.flight_number!!,
        auto_update = this.auto_update!!,
        largeLink = this.links!!.patch.large.toString()
    )
}
    fun Launches.toLaunchesEto(): LaunchEto {
        return LaunchEto(
            id = this.id!!,
            details = this.details!!,
            rocket = this.rocket!!,
            flight_number = this.flight_number!!,
            large_link = this.links!!.patch.large!!
        )
}