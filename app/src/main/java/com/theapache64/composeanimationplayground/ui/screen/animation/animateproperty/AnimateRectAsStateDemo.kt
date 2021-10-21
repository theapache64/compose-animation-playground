package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.rect

import androidx.compose.animation.core.animateRectAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimateRectAsStateDemo(
    isActive: Boolean
) {
    val targetRect = if (isActive) {
        Rect(0f, 0f, 100f, 100f)
    } else {
        Rect(100f, -100f, 200f, 200f)
    }
    val animatedRect by animateRectAsState(
        targetValue = targetRect,
        animationSpec = tween(durationMillis = 3000)
    )

    Box(
        modifier = Modifier
            .offset(animatedRect.left.dp, animatedRect.top.dp)
            .size(animatedRect.right.dp, animatedRect.bottom.dp)
            .background(Color.Red)
    )
}
