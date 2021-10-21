package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.dp

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo


@Composable
fun AnimateDpAsStateDemo(
    isActive: Boolean
) {
    val targetDp = if (isActive) 50.dp else 100.dp
    val animatedDp by animateDpAsState(targetValue = targetDp)

    TeslaLogo(
        modifier = Modifier
            .size(animatedDp)
    )
}
