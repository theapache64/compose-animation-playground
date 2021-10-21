package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.ChildSample
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo


@Composable
fun AnimateFloatAsStateDemo(
    isActive: Boolean
) {
    val targetValue = if (isActive) 0f else 100f

    Column {
        ChildSample(title = "Simple Usage") {
            SimpleUsage(targetValue)
        }

        ChildSample(title = "animationSpec usage") {
            AnimationSpecUsage(targetValue)
        }
    }
}


@Composable
private fun SimpleUsage(
    targetValue: Float
) {
    val animatedValue by animateFloatAsState(targetValue = targetValue)
    TeslaLogo(
        modifier = Modifier.padding(start = animatedValue.dp)
    )
}

@Composable
private fun AnimationSpecUsage(targetValue: Float) {
    val animatedValue by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = tween(1000, 1000, easing = FastOutSlowInEasing)
    )
    TeslaLogo(
        modifier = Modifier.padding(start = animatedValue.dp)
    )
}