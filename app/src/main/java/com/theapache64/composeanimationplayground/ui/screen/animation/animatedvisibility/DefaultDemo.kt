package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun DefaultDemo(
    isVisible: (Boolean)
) {
    AnimatedVisibility(visible = isVisible) {
        TeslaLogo()
    }
}
