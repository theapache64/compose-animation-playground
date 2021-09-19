package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo
import com.theapache64.composeanimationplayground.ui.screen.animation.DURATION

@Composable
fun ExpandShrinkVerticallyDemo(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(DURATION)
        ),
        exit = shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(DURATION)
        )
    ) {
        TeslaLogo()
    }
}