package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun FadeInFadeOutDemo(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(DURATION)),
        exit = fadeOut(animationSpec = tween(DURATION))
    ) {
        TeslaLogo()
    }
}
