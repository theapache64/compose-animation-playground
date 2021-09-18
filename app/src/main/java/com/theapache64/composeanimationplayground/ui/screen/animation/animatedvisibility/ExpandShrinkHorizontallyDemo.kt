package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo


@Composable
fun ExpandShrinkHorizontallyDemo(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandHorizontally(
            expandFrom = Alignment.Start,
            animationSpec = tween(DURATION)
        ),
        exit = shrinkHorizontally(
            shrinkTowards = Alignment.Start,
            animationSpec = tween(DURATION)
        )
    ) {
        TeslaLogo()
    }
}