package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

@Composable
fun AnimatableScreen() {
    BigColumn {
        var flag by remember { mutableStateOf(false) }
        val color = remember { Animatable(Color.Red) }
        LaunchedEffect(flag) {
            val newColor = if (flag) {
                Color.Green
            } else {
                Color.Blue
            }
            color.animateTo(newColor, animationSpec = tween(3000))
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color.value)
                .clickable {
                    flag = !flag
                }
        )
    }
}