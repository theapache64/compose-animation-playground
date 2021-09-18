package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo


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


@Composable
fun AnimatedVisibilityAdvancedDemo(isVisible: Boolean) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { with(density) { -100.dp.roundToPx() } },
            animationSpec = tween(durationMillis = DURATION)
        ) + expandVertically(expandFrom = Alignment.Bottom, animationSpec = tween(DURATION))
                + fadeIn(initialAlpha = 0.3f, animationSpec = tween(DURATION)),
        exit =
        slideOutVertically(
            targetOffsetY = { with(density) { -100.dp.roundToPx() } },
            animationSpec = tween(DURATION)
        ) + shrinkVertically(shrinkTowards = Alignment.Top, animationSpec = tween(DURATION))
                + fadeOut(animationSpec = tween(DURATION))

    ) {
        TeslaLogo()
    }
}