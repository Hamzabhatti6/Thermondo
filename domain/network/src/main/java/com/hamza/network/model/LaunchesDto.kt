package com.hamza.network.model

import com.google.gson.annotations.SerializedName

data class LaunchesDto(@SerializedName("rocket") val rocket : String,
                       @SerializedName("details") val details : String,
                       @SerializedName("id") val id : String,
                       @SerializedName("flight_number") val flight_number : Int,
                       @SerializedName("auto_update") val auto_update : Boolean,
                       @SerializedName("links") val links : LinksDto,
)

data class LinksDto(
    @SerializedName("patch") val patch : PatchDto
)
data class PatchDto(
    @SerializedName("small") val small : String,
    @SerializedName("large") val large : String)
