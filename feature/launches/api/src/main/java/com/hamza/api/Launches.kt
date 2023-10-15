package com.hamza.api

data class Launches(val rocket : String? = null,
                    val details : String? = null,
                    val id : String? = null,
                    val flight_number : Int? = null,
                    val auto_update : Boolean? = false,
                    val links : Links? = null)
data class Links (
    val patch: Patch
)

data class Patch (
    val small : String? = null,
    val large : String? = null)
