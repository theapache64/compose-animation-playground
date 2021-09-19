package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo
import com.theapache64.composeanimationplayground.ui.screen.animation.DURATION

@Composable
fun SlideInOutDemo(isVisible: Boolean) {
    val density = LocalDensity.current
    val offset = remember {
        with(density) {
            IntOffset(-100.dp.roundToPx(), -100.dp.roundToPx())
        }
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = slideIn(initialOffset = { offset }, animationSpec = tween(DURATION)),
        exit = slideOut(targetOffset = { offset }, animationSpec = tween(DURATION)),
    ) {
        TeslaLogo()
    }
}

