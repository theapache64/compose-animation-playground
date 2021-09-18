package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@Composable
fun ChildBasedAnimationDemo() {
    BigColumn {

        var isVisible by remember { mutableStateOf(true) }
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(2000)),
            exit = fadeOut(animationSpec = tween(2000))
        ) {
            TeslaLogo(
                modifier = Modifier.animateEnterExit(
                    enter = slideInHorizontally(animationSpec = tween(2000)),
                    exit = slideOutVertically(animationSpec = tween(2000))
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Toggle")
        }
    }
}