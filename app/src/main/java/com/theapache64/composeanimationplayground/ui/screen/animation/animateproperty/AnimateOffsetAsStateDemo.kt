package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.offset

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo


@Composable
fun AnimateOffsetAsStateDemo(
    isActive: Boolean
) {
    val targetOffset = if (isActive) {
        Offset(100f, 20f)
    } else {
        Offset(30f, -130f)
    }
    val animatedOffset by animateOffsetAsState(
        targetValue = targetOffset
    )

    TeslaLogo(
        modifier = Modifier
            .offset(
                x = animatedOffset.x.dp,
                y = animatedOffset.y.dp
            )
    )
}
