package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun AnimateEnterExitOnChildDemo(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(animationSpec = tween(2000)),
        exit = slideOutVertically(animationSpec = tween(2000))
    ) {
        TeslaLogo(
            modifier = Modifier.animateEnterExit(
                enter = fadeIn(animationSpec = tween(2000)),
                exit = fadeOut(animationSpec = tween(2000))
            )
        )
    }
}