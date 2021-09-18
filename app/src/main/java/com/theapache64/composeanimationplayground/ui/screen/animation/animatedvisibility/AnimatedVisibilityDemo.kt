package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun DefaultDemo(
    isVisible: (Boolean)
) {
    AnimatedVisibility(visible = isVisible) {
        TeslaLogo()
    }
}

private const val DURATION = 2000

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