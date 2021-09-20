package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

private enum class BoxState { SMALL_RED, MEDIUM_GREEN, LARGE_BLUE }

@Preview(device = Devices.DEFAULT)
@Composable
fun UpdateTransitionScreen() {
    BigColumn {
        var currentState by remember { mutableStateOf(BoxState.SMALL_RED) }
        val transition = updateTransition(targetState = currentState, "Box (Size + Color)")
        val size by transition.animateDp(
            label = "Size transition",
            transitionSpec = { tween(3000) }
        ) {
            when (it) {
                BoxState.SMALL_RED -> 100.dp
                BoxState.MEDIUM_GREEN -> 200.dp
                BoxState.LARGE_BLUE -> 350.dp
            }
        }

        val color by transition.animateColor(
            label = "Color transition",
            transitionSpec = { tween(3000) }
        ) {
            when (it) {
                BoxState.SMALL_RED -> Color.Red
                BoxState.MEDIUM_GREEN -> Color.Green
                BoxState.LARGE_BLUE -> Color.Blue
            }
        }

        Box(
            modifier = Modifier
                .size(size)
                .background(color = color)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "CurrentState: ${transition.currentState}")
        Text(text = "TargetState: ${transition.targetState}")

        Row {

            Button(onClick = { currentState = BoxState.SMALL_RED }) {
                Text(text = "SMALL RED")
            }

            Button(onClick = { currentState = BoxState.MEDIUM_GREEN }) {
                Text(text = "MEDIUM GREEN")
            }

            Button(onClick = { currentState = BoxState.LARGE_BLUE }) {
                Text(text = "LARGE BLUE")
            }
        }
    }
}