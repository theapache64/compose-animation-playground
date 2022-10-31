package com.theapache64.composeanimationplayground.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapache64.composeanimationplayground.model.AnimationScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.*
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.AnimateContentSizeScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.CustomTransitionScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.DefaultScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent.SizeTransformScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.MutableTransitionStateScreen
import com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.AnimatePropertyAsStateScreen
import com.theapache64.composeanimationplayground.ui.screen.selector.AnimationSelector
import com.theapache64.composeanimationplayground.ui.screen.splash.SplashScreen

// TODO : Refactor
private const val BASE_URL =
    "https://github.com/theapache64/compose-animation-playground/blob/master/app/src/main/java/com/theapache64/composeanimationplayground/ui/screen/animation"


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        // startDestination = "animate*AsState (TODO)"
        startDestination = Screen.Splash.route
    ) {
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
                val context = LocalContext.current
                animationScreen.content(
                    onBackPressed = {
                        navController.navigateUp()
                    },
                    onItemClicked = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$BASE_URL/${it.path}"))
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}

private val animationScreens: List<AnimationScreen> by lazy {
    mutableListOf(
        AnimationScreen("AnimatedVisibility") { onBackClicked, onItemClicked ->
            AnimatedVisibilityScreen(onBackClicked, onItemClicked)
        },
        AnimationScreen("MutableTransitionState") { _, _ ->
            MutableTransitionStateScreen()
        },
        AnimationScreen("AnimatedContent") { _, _ ->
            DefaultScreen()
        },
        AnimationScreen("Custom AnimatedContent") { _, _ ->
            CustomTransitionScreen()
        },
        AnimationScreen("SizeTransform Sample") { _, _ ->
            SizeTransformScreen()
        },
        AnimationScreen("animateContentSize Sample") { _, _ ->
            AnimateContentSizeScreen()
        },

        AnimationScreen("Crossfade Sample") { _, _ ->
            CrossfadeScreen()
        },
        AnimationScreen("animate*AsState (TODO)") { onBackClicked, onItemClicked ->
            AnimatePropertyAsStateScreen(onBackClicked, onItemClicked)
        },

        AnimationScreen("Animatable") { _, _ -> AnimatableScreen() },
        AnimationScreen("updateTransition") { _, _ ->
            UpdateTransitionScreen()
        },
        AnimationScreen("updateTransition with AnimatedVisibility") { _, _ ->
            UpdateTransitionAnimateContentScreen()
        },
        AnimationScreen("createChildTransitionDemo") { _, _ ->
            ChildTransitionDemo()
        },
        AnimationScreen("Reusable updateTransition") { _, _ -> WIP() },
        AnimationScreen("rememberInfiniteTransition") { _, _ -> InfiniteTransitionDemo() },
        AnimationScreen("TargetBasedAnimation") { _, _ -> TODO() },
        AnimationScreen("animationSpec : spring") { _, _ -> TODO("Demo dampingRatio and stiffness with tabs maybe") },
        AnimationScreen("animationSpec : tween") { _, _ -> TODO("Demo with two boxes and custom controls") },
        AnimationScreen("animationSpec : keyframes") { _, _ -> TODO("Demo with two boxes and custom controls") },
        AnimationScreen("animationSpec : repeatable") { _, _ -> TODO() },
        AnimationScreen("animationSpec : infiniteRepeatable") { _, _ -> TODO() },
        AnimationScreen("animationSpec : snap") { _, _ -> TODO() },
        AnimationScreen("animationSpec : Easing") { _, _ -> TODO() },
        AnimationScreen("Custom AnimationVector") { _, _ -> TODO() },
        AnimationScreen("Gesture Animation : SwipeToDismiss") { _, _ -> TODO() },
    )
}

@Composable
fun WIP(message: String? = null) {
    Text(text = message ?: "Work In Progress")
}
