package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun ScaleInOutDemo(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = scaleIn(initialScale = 0.5f, animationSpec = tween(DURATION)),
        exit = scaleOut(targetScale = 0.5f, animationSpec = tween(DURATION))
    ) {
        TeslaLogo()
    }
}