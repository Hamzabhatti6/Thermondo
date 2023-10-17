package com.hamza.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class LaunchEto(
    @PrimaryKey val id: String,
    @ColumnInfo("details") val details : String,
    @ColumnInfo("rocket") val rocket : String,
    @ColumnInfo("flight_number") val flight_number : Int,
    @ColumnInfo("large_link") val large_link : String
)