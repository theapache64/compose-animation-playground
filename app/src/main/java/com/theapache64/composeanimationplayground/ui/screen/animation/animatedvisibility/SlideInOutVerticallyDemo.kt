package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo
import com.theapache64.composeanimationplayground.ui.screen.animation.DURATION

@Composable
fun SlideInOutVerticallyDemo(isVisible: Boolean) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = {
                with(density) {
                    100.dp.roundToPx()
                }
            }, animationSpec = tween(DURATION)
        ),
        exit = slideOutVertically(
            targetOffsetY = {
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