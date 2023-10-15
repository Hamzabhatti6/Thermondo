package com.hamza.domain.extention

import com.hamza.api.Launches
import com.hamza.api.Links
import com.hamza.api.Patch
import com.hamza.network.model.LaunchesDto
import com.hamza.network.model.LinksDto
import com.hamza.network.model.PatchDto

fun LaunchesDto.toLaunches() : Launches {
    return Launches(
        rocket = this.rocket,
        details = this.details,
        id = this.id,
        flight_number = this.flight_number,
        auto_update = this.auto_update,
        links =  this.links.toLinks()
        )
}

fun LinksDto.toLinks() : Links {
    return Links(
        patch = this.patch.toPatch()
    )
}

fun PatchDto.toPatch() : Patch {
    return Patch(
        small = this.small,
        large = this.large)
}
fun List<LaunchesDto>.toLaunches() : List<Launches> {
    return this.map { it.toLaunches() }
}

