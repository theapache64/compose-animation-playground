package com.theapache64.composeanimationplayground.ui.screen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Dashboard : Screen("dashboard")
    object AnimatedVisibility : Screen("animated_visibility")
}