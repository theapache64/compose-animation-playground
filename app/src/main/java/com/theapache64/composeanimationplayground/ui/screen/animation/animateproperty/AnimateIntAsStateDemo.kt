package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun AnimateIntAsStateDemo(
    isActive: Boolean
) {
    val targetInt = if (isActive) 50 else 100
    val animatedInt by animateIntAsState(targetValue = targetInt)

    TeslaLogo(
        modifier = Modifier.size(animatedInt.dp)
    )
}
