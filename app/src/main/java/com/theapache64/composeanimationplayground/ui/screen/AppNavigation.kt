package com.theapache64.composeanimationplayground.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapache64.composeanimationplayground.model.AnimationScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.AnimatableScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.AnimatedVisibilityScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.CrossfadeScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.AnimateContentSizeScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.CustomTransitionScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.DefaultScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.SizeTransformScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.MutableTransitionStateScreen
import com.theapache64.composeanimationplayground.ui.screen.selector.AnimationSelector
import com.theapache64.composeanimationplayground.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    //NavHost(navController = navController, startDestination = animationScreens[8].title) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
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
            MutableTransitionStateScreen()
        },
        AnimationScreen("AnimatedContent") {
            DefaultScreen()
        },
        AnimationScreen("Custom AnimatedContent") {
            CustomTransitionScreen()
        },
        AnimationScreen("SizeTransform Sample") {
            SizeTransformScreen()
        },
        AnimationScreen("animateContentSize Sample") {
            AnimateContentSizeScreen()
        },

        AnimationScreen("Crossfade Sample") {
            CrossfadeScreen()
        },
        AnimationScreen("animate*AsState (TODO)") {
            TODO("TODO: Float, Color, Dp, Size, Bounds, Offset, Rect, Int, IntOffset, and IntSize")
        },

        AnimationScreen("Animatable") { AnimatableScreen() },
        AnimationScreen("updateTransition") { TODO("https://developer.android.com/jetpack/compose/animation#animatable") },
        AnimationScreen("updateTransition with AnimatedVisibility") { TODO("https://developer.android.com/jetpack/compose/animation#use-transition-with-animatedvisibility-and-animatedcontent") },
        AnimationScreen("Reusable updateTransition") { TODO() },
        AnimationScreen("rememberInfiniteTransition") { TODO() },
        AnimationScreen("TargetBasedAnimation") { TODO() },
        AnimationScreen("animationSpec : spring") { TODO("Demo dampingRatio and stiffness with tabs maybe") },
        AnimationScreen("animationSpec : tween") { TODO("Demo with two boxes and custom controls") },
        AnimationScreen("animationSpec : keyframes") { TODO("Demo with two boxes and custom controls") },
        AnimationScreen("animationSpec : repeatable") { TODO() },
        AnimationScreen("animationSpec : infiniteRepeatable") { TODO() },
        AnimationScreen("animationSpec : snap") { TODO() },
        AnimationScreen("animationSpec : Easing") { TODO() },
        AnimationScreen("Custom AnimationVector") { TODO() },
        AnimationScreen("Gesture Animation : SwipeToDismiss") { TODO() },
    )
}