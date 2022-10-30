package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

/**
 * InfiniteTransition holds one or more child animations like Transition,
 * but the animations start running as soon as they enter the composition and do not stop unless they are removed
 *
 * https://developer.android.com/jetpack/compose/animation#rememberinfinitetransition
 */
@Composable
fun InfiniteTransitionDemo() {
    BigColumn {
        val infiniteTransition = rememberInfiniteTransition()
        val fontSize by infiniteTransition.animateFloat(
            initialValue = 16f,
            targetValue = 24f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        val color by infiniteTransition.animateColor(
            initialValue = Color.Red,
            targetValue = Color.Green,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Text(text = "Infinite Transition", color = color, fontSize = fontSize.sp)
    }
}