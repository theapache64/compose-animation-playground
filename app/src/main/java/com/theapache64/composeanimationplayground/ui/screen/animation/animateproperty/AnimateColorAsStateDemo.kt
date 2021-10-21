package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.color

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimateColorAsStateDemo(
    isActive: Boolean
) {
    val targetColor = if (isActive) Color.Red else Color.Green
    val animatedColor by animateColorAsState(
        targetValue = targetColor,
        animationSpec = tween(durationMillis = 2500)
    )

    Box(
        modifier = Modifier
            .size(80.dp)
            .background(animatedColor)
    )
}
