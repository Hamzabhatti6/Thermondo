package com.hamza.presentation.ui.navigation

sealed class Screens(val route: String) {
    object Home : Screens("home")
    object LaunchesDetail : Screens("detail")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}