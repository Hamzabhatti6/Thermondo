package com.hamza.presentation.ui.data

data class LaunchesDetailsUiModel(
    val rocket : String,
    val details : String,
    val id : String,
    val flight_number : Int,
    val auto_update : Boolean,
    val largeLink : String
)