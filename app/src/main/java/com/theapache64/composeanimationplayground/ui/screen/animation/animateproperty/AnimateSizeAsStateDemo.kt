package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty

import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimateSizeAsStateDemo(
    isActive: Boolean
) {
    val targetSize = if (isActive) {
        Size(300f, 30f)
    } else {
        Size(30f, 300f)
    }
    val animatedSize by animateSizeAsState(targetValue = targetSize)

    Box(
        modifier = Modifier
            .size(
                width = animatedSize.width.dp,
                height = animatedSize.height.dp
            ).background(Color.Red)
    )
}
