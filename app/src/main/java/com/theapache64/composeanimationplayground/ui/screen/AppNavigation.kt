package com.theapache64.composeanimationplayground.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapache64.composeanimationplayground.model.AnimationScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.AnimatedVisibilityScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.AnimateEnterExitOnChildDemo
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.MutableTransitionStateDemoScreen
import com.theapache64.composeanimationplayground.ui.screen.selector.AnimationSelector
import com.theapache64.composeanimationplayground.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = animationScreens[0].title) {
//    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
        // Splash
        composable(Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    navController.popBackStack() // Remove splash from stack
                    navController.navigate(Screen.Dashboard.route) // Move to dashboard
                }
            )
        }

        // Dashboard
        composable(Screen.Dashboard.route) {
            AnimationSelector(
                animations = animationScreens,
                onAnimationSelected = { animation ->
                    navController.navigate(animation.title)
                }
            )
        }

        for (animationScreen in animationScreens) {
            composable(animationScreen.title) {
                animationScreen.content(onBackPressed = {
                    navController.navigateUp()
                })
            }
        }
    }
}

private val animationScreens: List<AnimationScreen> by lazy {
    mutableListOf(
        AnimationScreen("AnimatedVisibility") { onBackClicked ->
            AnimatedVisibilityScreen(onBackClicked)
        },
        AnimationScreen("MutableTransitionState") {
            MutableTransitionStateDemoScreen()
        },
        AnimationScreen("Animate enter and exit for children") {},
    )
}