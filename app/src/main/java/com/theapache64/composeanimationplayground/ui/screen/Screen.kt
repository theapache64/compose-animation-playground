package com.theapache64.composeanimationplayground.ui.screen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Dashboard : Screen("dashboard")
    // Wondering how we pass arguments using this strucure?
    // See here -> https://github.com/chrisbanes/tivi/blob/add9b7d65633596fcebe32df5ef9ae9b40b1846f/app/src/main/java/app/tivi/AppNavigation.kt#L70
}