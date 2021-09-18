package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun SlideInOutHorizontallyDemo(isVisible: Boolean) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(
            initialOffsetX = {
                with(density) {
                    100.dp.roundToPx()
                }
            }, animationSpec = tween(DURATION)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = {
                with(density) {
                    100.dp.roundToPx()
                }
            },
            animationSpec = tween(DURATION)
        )
    ) {
        TeslaLogo()
    }
}