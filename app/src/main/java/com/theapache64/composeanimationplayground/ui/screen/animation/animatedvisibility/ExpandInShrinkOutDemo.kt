package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun ExpandInShrinkOutDemo(isVisible: Boolean) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = isVisible,
        enter = expandIn(
            expandFrom = Alignment.TopStart,
            animationSpec = tween(DURATION),
            initialSize = {
                with(density) {
                    IntSize(40.dp.roundToPx(), 40.dp.roundToPx())
                }
            }
        ),
        exit = shrinkOut(
            shrinkTowards = Alignment.BottomEnd,
            animationSpec = tween(DURATION),
            targetSize = {
                with(density) {
                    IntSize(10.dp.roundToPx(), 10.dp.roundToPx())
                }
            },
        )
    ) {
        TeslaLogo()
    }
}