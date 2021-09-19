package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo
import com.theapache64.composeanimationplayground.ui.screen.animation.DURATION
import com.theapache64.composeanimationplayground.ui.theme.TeslaRed

@Composable
fun TransitionApiDemo(isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = scaleIn(animationSpec = tween(DURATION)),
        exit = scaleOut(animationSpec = tween(DURATION))
    ) {
        val animatedBgColor by transition.animateColor(
            label = "Color animation",
            transitionSpec = { tween(DURATION) }
        ) { state ->
            if (state == EnterExitState.Visible) {
                TeslaRed
            } else {
                Color.Transparent
            }
        }

        TeslaLogo(
            modifier = Modifier
                .background(animatedBgColor)
                .padding(5.dp)
        )
    }
}